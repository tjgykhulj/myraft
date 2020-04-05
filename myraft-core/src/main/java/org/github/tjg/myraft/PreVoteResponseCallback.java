package org.github.tjg.myraft;

import com.baidu.brpc.client.RpcCallback;
import lombok.extern.slf4j.Slf4j;
import org.github.tjg.myraft.model.NodeStatus;
import org.github.tjg.myraft.model.proto.VoteRequest;
import org.github.tjg.myraft.model.proto.VoteResponse;

import java.util.Map;

@Slf4j
public class PreVoteResponseCallback implements RpcCallback<VoteResponse> {

    private Peer peer;
    private VoteRequest request;

    public PreVoteResponseCallback(Peer peer, VoteRequest request) {
        this.peer = peer;
        this.request = request;
    }

    @Override
    public void success(VoteResponse resp) {
        Node.lock();
        try {
            Node node = Node.CURRENT_NODE;
            peer.setVoteGranted(resp.getGranted());
            // 当前结点已不再是pre候选人，或者当前任期与请求时相比已更新 -> 表示请求后状态发生了变化，结果无意义了
            if (node.getStatus() != NodeStatus.PRE_CANDIDATE || node.getCurrentTerm() != request.getTerm()) {
                return;
            }
            // 如果请求结果的term大于当前结点的term，进行一次stepDown（意思是？）
            if (resp.getTerm() > node.getCurrentTerm()) {
                log.info("Received request preVote response from server {} " +
                                "in term {} (this server's term was {})",
                        peer.getServer().getServerId(),
                        resp.getTerm(),
                        node.getCurrentTerm());
                node.stepDown(resp.getTerm());
                return;
            }
            // 未被对方认可
            if (!resp.getGranted()) {
                log.info("Vote denied by server {} with term {}, this server's term is {}",
                        peer.getServer().getServerId(), resp.getTerm(), node.getCurrentTerm());
                return;
            }

            log.info("Got vote from server {} for term {}",
                    peer.getServer().getServerId(), node.getCurrentTerm());
            int voteGrantedNum = 1;
            for (Map.Entry<Integer, Peer> p: node.getPeerMap().entrySet()) {
                if (p.getValue().getVoteGranted() && p.getKey() != node.getLocalServer().getServerId()) {
                    voteGrantedNum += 1;
                }
            }
            log.info("voteGrantedNum={}", voteGrantedNum);
            if (voteGrantedNum > node.getPeerMap().size() / 2) {
                log.info("Got majority vote, serverId={} start vote", node.getLocalServer().getServerId());
                node.startVote();
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

