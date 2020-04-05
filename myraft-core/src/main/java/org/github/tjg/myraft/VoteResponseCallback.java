package org.github.tjg.myraft;

import com.baidu.brpc.client.RpcCallback;
import lombok.extern.slf4j.Slf4j;
import org.github.tjg.myraft.model.NodeStatus;
import org.github.tjg.myraft.model.proto.VoteRequest;
import org.github.tjg.myraft.model.proto.VoteResponse;

import java.util.Map;

@Slf4j
public class VoteResponseCallback implements RpcCallback<VoteResponse> {

    private Peer peer;
    private VoteRequest request;

    public VoteResponseCallback(Peer peer, VoteRequest request) {
        this.peer = peer;
        this.request = request;
    }

    @Override
    public void success(VoteResponse resp) {
        Node.lock();
        try {
            Node node = Node.CURRENT_NODE;
            peer.setVoteGranted(resp.getGranted());
            // 当前结点已不再是候选人，或者当前任期已更新 -> 表示请求后状态发生了变化，结果无意义了
            if (node.getStatus() != NodeStatus.CANDIDATE || node.getCurrentTerm() != request.getTerm()) {
                return;
            }
            // 如果请求结果的term大于当前结点的term，进行一次stepDown（更新当前点的term）
            if (resp.getTerm() > node.getCurrentTerm()) {
                log.info("Received request vote response from server {} " +
                                "in term {} (this server's term was {})",
                        peer.getServer().getServerId(),
                        resp.getTerm(),
                        node.getCurrentTerm());
                node.stepDown(resp.getTerm());
                return;
            }
            if (!resp.getGranted()) {
                log.info("Vote denied by server {} with term {}, this server's term is {}",
                        peer.getServer().getServerId(), resp.getTerm(), node.getCurrentTerm());
                return;
            }

            // 开始计票，过半数成为leader
            log.info("Got vote from server {} for term {}",
                    peer.getServer().getServerId(), node.getCurrentTerm());
            int voteGrantedNum = 0;
            if (node.getVoteFor() == node.getLocalServer().getServerId()) {
                voteGrantedNum += 1;
            }

            for (Map.Entry<Integer, Peer> p : node.getPeerMap().entrySet()) {
                if (p.getValue().getVoteGranted() && p.getKey() != node.getLocalServer().getServerId()) {
                    voteGrantedNum += 1;
                }
            }
            log.info("voteGrantedNum={}", voteGrantedNum);
            if (voteGrantedNum > node.getPeerMap().size() / 2) {
                log.info("Got majority vote, serverId={} become leader", node.getLocalServer().getServerId());
                node.becomeLeader();
            }
        } finally {
            Node.unlock();
        }
    }

    @Override
    public void fail(Throwable e) {
        peer.setVoteGranted(false);
    }
}
