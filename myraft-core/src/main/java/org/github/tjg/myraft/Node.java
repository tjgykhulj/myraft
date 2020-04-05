package org.github.tjg.myraft;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.github.tjg.myraft.model.NodeStatus;
import org.github.tjg.myraft.model.proto.AppendEntriesRequest;
import org.github.tjg.myraft.model.proto.AppendEntriesResponse;
import org.github.tjg.myraft.model.proto.ResCode;
import org.github.tjg.myraft.model.proto.Server;
import org.github.tjg.myraft.model.proto.VoteRequest;
import org.github.tjg.myraft.storage.SegmentedLog;
import org.github.tjg.myraft.storage.Snapshot;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@Slf4j
public class Node {

    // 定时任务、brpc回调时，会并发冲突
    private static Lock LOCK = new ReentrantLock();
    public static Node CURRENT_NODE;

    // this node's status
    private NodeStatus status = NodeStatus.FOLLOWER;
    // 在当前获得选票的候选人的Id
    private int voteFor;
    private Server localServer;
    private List<Server> serverList;
    // TODO 为什么要concurrentMap，目前感觉不会写入
    private Map<Integer, Peer> peerMap = new ConcurrentHashMap<>();
    private long currentTerm;
    private int leaderServerId;
    private Snapshot snapshot;

    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutorService;
    private ScheduledFuture electionScheduledFuture;
    private ScheduledFuture heartbeatScheduledFuture;

    private Config config;

    private SegmentedLog raftLog;
    // 已知的最大的已经被提交的日志条目的索引值
    private long commitIndex;

    public void Node(List<Server> servers, Server localServer) {
        this.config = new Config();
        this.serverList = servers;
        this.localServer = localServer;
        updateCurrentNode(this);
    }

    public void init() {
        for (Server s: serverList) {
            if (peerMap.containsKey(s.getServerId()) || localServer.getServerId() == s.getServerId()) {
                continue;
            }
            Peer peer = new Peer(s);
            peer.setNextIndex(raftLog.getLastLogIndex() + 1);
            peerMap.put(s.getServerId(), peer);
        }
        // start election check loop
        resetElectionTimer();
    }

    private static void updateCurrentNode(Node node) {
        Node.CURRENT_NODE = node;
    }


    static void lock() {
        Node.LOCK.lock();
    }

    static void unlock() {
        Node.LOCK.unlock();
    }

    /**
     *
     * @param newTerm 当前结点待更新的任期
     */
    public void stepDown(long newTerm) {
        // can't be happen
        if (currentTerm > newTerm) {
            throw new RuntimeException("step down by a less term");
        }
        // update term
        if (currentTerm < newTerm) {
            currentTerm = newTerm;
            leaderServerId = 0;
            voteFor = 0;
            raftLog.updateMetaData(currentTerm, voteFor, null, null);
        }
        status = NodeStatus.FOLLOWER;
        // stop heartbeat because it's not a leader node anymore
        if (heartbeatScheduledFuture != null && !heartbeatScheduledFuture.isDone()) {
            heartbeatScheduledFuture.cancel(true);
        }
        resetElectionTimer();
    }

    public void becomeLeader() {
        this.status = NodeStatus.LEADER;
        this.leaderServerId = localServer.getServerId();
        // stop requestVote timer
        if (electionScheduledFuture != null && !electionScheduledFuture.isDone()) {
            electionScheduledFuture.cancel(true);
        }
        // start heartbeat timer
        startNewHeartbeat();
    }

    private void startNewHeartbeat() {
        log.debug("start new heartbeat, peers={}", peerMap.keySet());
        for (final Peer peer : peerMap.values()) {
            executorService.submit(() -> appendEntries(peer));
        }
        // 若未结束，直接关闭
        if (heartbeatScheduledFuture != null && !heartbeatScheduledFuture.isDone()) {
            heartbeatScheduledFuture.cancel(true);
        }
        // 在heartbeat period ms时间后，再次执行heartbeat
        heartbeatScheduledFuture = scheduledExecutorService.schedule(
                this::startNewHeartbeat,
                config.getHeartbeatPeriodMilliseconds(),
                TimeUnit.MILLISECONDS);
    }

    // 重置选举倒计时
    private void resetElectionTimer() {
        if (electionScheduledFuture != null && !electionScheduledFuture.isDone()) {
            electionScheduledFuture.cancel(true);
        }
        // election timeout, start pre_vote
        electionScheduledFuture = scheduledExecutorService.schedule(
                this::startPreVote,
                getElectionTimeoutMs(),
                TimeUnit.MILLISECONDS);

    }

    private void appendEntries(Peer peer) {
        boolean isNeedInstallSnapshot = false;
        lock();
        try {
            long firstLogIndex = raftLog.getFirstLogIndex();
            if (peer.getNextIndex() < firstLogIndex) {
                isNeedInstallSnapshot = true;
            }
        } finally {
            unlock();
        }
        log.debug("is need snapshot={}, peer={}", isNeedInstallSnapshot, peer.getServer().getServerId());

        if (isNeedInstallSnapshot) {
            if (!installSnapshot(peer)) {
                return;
            }
        }

        long lastSnapshotIndex;
        long lastSnapshotTerm;
        snapshot.lock();
        try {
            lastSnapshotIndex = snapshot.getMetaData().getLastIncludedIndex();
            lastSnapshotTerm = snapshot.getMetaData().getLastIncludedTerm();
        } finally {
            snapshot.unlock();
        }

        lock();
        AppendEntriesRequest.Builder requestBuilder = AppendEntriesRequest.newBuilder();
        try {
            long firstLogIndex = raftLog.getFirstLogIndex();
            Validate.isTrue(peer.getNextIndex() >= firstLogIndex);
            long prevLogIndex = peer.getNextIndex() - 1;
            long prevLogTerm;
            if (prevLogIndex == 0) {
                prevLogTerm = 0;
            } else if (prevLogIndex == lastSnapshotIndex) {
                prevLogTerm = lastSnapshotTerm;
            } else {
                prevLogTerm = raftLog.getEntryTerm(prevLogIndex);
            }
            requestBuilder.setServerId(localServer.getServerId());
            requestBuilder.setTerm(currentTerm);
            requestBuilder.setPrevLogTerm(prevLogTerm);
            requestBuilder.setPrevLogIndex(prevLogIndex);
            long numEntries = packEntries(peer.getNextIndex(), requestBuilder);
            requestBuilder.setCommitIndex(Math.min(commitIndex, prevLogIndex + numEntries));
        } finally {
            unlock();
        }
        AppendEntriesRequest request = requestBuilder.build();
        AppendEntriesResponse response = peer.getRaftConsensusServiceAsync().appendEntries(request);


        lock();
        try {
            if (response == null) {
                log.warn("appendEntries with peer[{}:{}] failed",
                        peer.getServer().getIp(),
                        peer.getServer().getPort());
                if (serverList.stream().noneMatch(s -> s.getServerId() == peer.getServer().getServerId())) {
                    peerMap.remove(peer.getServer().getServerId());
                    peer.getRpcClient().stop();
                }
                return;
            }
            log.info("AppendEntries response[{}] from server {} " +
                            "in term {} (my term is {})",
                    response.getResCode(), peer.getServer().getServerId(),
                    response.getTerm(), currentTerm);
            //TODO
        } finally {
            unlock();
        }
    }

    // 随机选举超时时间
    private int getElectionTimeoutMs() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomElectionTimeout = config.getElectionTimeoutMilliseconds()
                + random.nextInt(0, config.getElectionTimeoutMilliseconds());
        log.debug("new election time is after {} ms", randomElectionTimeout);
        return randomElectionTimeout;
    }

    /**
     * 客户端发起pre-vote请求。
     * pre-requestVote/vote是典型的二阶段实现。
     * 作用是防止某一个节点断网后，不断的增加term发起投票；
     * 当该节点网络恢复后，会导致集群其他节点的term增大，导致集群状态变更。
     */
    private void startPreVote() {
        lock();
        try {
            if (serverList.stream().noneMatch(s -> s.getServerId() == localServer.getServerId())) {
                resetElectionTimer();
                return;
            }
            log.info("Running pre-requestVote in term {}", currentTerm);
            status = NodeStatus.PRE_CANDIDATE;
            serverList.stream()
                    .filter(s -> s.getServerId() != localServer.getServerId())
                    .map(s -> peerMap.get(s.getServerId()))
                    .filter(Objects::nonNull)
                    .forEach(peer -> executorService.submit(() -> preVote(peer)));
            resetElectionTimer();
        } finally {
            unlock();
        }
    }

    public void startVote() {
        lock();
        try {
            currentTerm++;
            status = NodeStatus.CANDIDATE;
            leaderServerId = 0;
            voteFor = localServer.getServerId();
            serverList.stream()
                    .filter(s -> s.getServerId() != localServer.getServerId())
                    .map(s -> peerMap.get(s.getServerId()))
                    .filter(Objects::nonNull)
                    .forEach(peer -> executorService.submit(() -> requestVote(peer)));
        } finally {
            unlock();
        }
    }

    public long getLastLogTerm() {
        long lastLogIndex = raftLog.getLastLogIndex();
        if (lastLogIndex >= raftLog.getFirstLogIndex()) {
            return raftLog.getEntryTerm(lastLogIndex);
        } else {
            // log为空，lastLogIndex == lastSnapshotIndex
            return snapshot.getMetaData().getLastIncludedTerm();
        }
    }

    /**
     * 客户端发起pre-vote请求
     * @param peer 服务端节点信息
     */
    private void preVote(Peer peer) {
        log.info("begin pre requestVote request");
        peer.setVoteGranted(null);
        VoteRequest request = VoteRequest.newBuilder()
                .setTerm(currentTerm)
                .setServerId(localServer.getServerId())
                .setLastLogIndex(raftLog.getLastLogIndex())
                .setLastLogTerm(getLastLogTerm())
                .build();
        peer.getRaftConsensusServiceAsync().preVote(
                request, new PreVoteResponseCallback(peer, request));
    }

    private void requestVote(Peer peer) {
        log.info("begin vote request");
        lock();
        try {
            peer.setVoteGranted(null);
            VoteRequest.Builder requestBuilder = VoteRequest.newBuilder();
            VoteRequest request = requestBuilder.setServerId(localServer.getServerId())
                    .setTerm(currentTerm)
                    .setLastLogIndex(raftLog.getLastLogIndex())
                    .setLastLogTerm(getLastLogTerm())
                    .build();
            peer.getRaftConsensusServiceAsync().requestVote(request, new VoteResponseCallback(peer, request));
        } finally {
            unlock();
        }
    }

    private boolean installSnapshot(Peer peer) {
        //TODO
        return false;
    }

    // in lock
    private long packEntries(long nextIndex, AppendEntriesRequest.Builder requestBuilder) {
        // TODO
        return 0;
    }
}
