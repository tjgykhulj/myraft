package org.github.tjg.myraft;

import com.baidu.brpc.client.BrpcProxy;
import com.baidu.brpc.client.RpcClient;
import com.baidu.brpc.client.instance.Endpoint;
import lombok.Data;
import org.github.tjg.myraft.model.proto.Server;
import org.github.tjg.myraft.service.RaftConsensusServiceAsync;

/**
 * 当前实例维护其它Raft的实例状态
 */
@Data
public class Peer {
    /**
     * 连续此Peer的brpc client
     */
    private RpcClient rpcClient;

    /**
     * Server端口信息
     */
    private Server server;

    /**
     * 对方是否投票当前自己（选举leader）
     * TODO 为什么要volatile?
     */
    private volatile Boolean voteGranted;

    /**
     * 需要发送给follower的下一个日志条目的索引值，只对leader有效
      */
    private long nextIndex;

    /**
     * has sync with leader
     */
    private boolean isCatchUp;

    /**
     *
     */
    private RaftConsensusServiceAsync raftConsensusServiceAsync;


    public Peer(Server s) {
        this.server = s;
        this.rpcClient = new RpcClient(new Endpoint(s.getIp(), s.getPort()));
        this.raftConsensusServiceAsync = BrpcProxy.getProxy(rpcClient, RaftConsensusServiceAsync.class);
        this.isCatchUp = false;
    }

}
