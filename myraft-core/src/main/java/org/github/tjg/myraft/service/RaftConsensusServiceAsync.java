package org.github.tjg.myraft.service;

import com.baidu.brpc.client.RpcCallback;
import org.github.tjg.myraft.model.proto.AppendEntriesRequest;
import org.github.tjg.myraft.model.proto.AppendEntriesResponse;
import org.github.tjg.myraft.model.proto.VoteRequest;
import org.github.tjg.myraft.model.proto.VoteResponse;

import java.util.concurrent.Future;

/**
 * 用于生成client异步调用所需的proxy
 */
public interface RaftConsensusServiceAsync extends RaftConsensusService {

    Future<VoteResponse> preVote(VoteRequest request, RpcCallback<VoteResponse> callback);

    Future<VoteResponse> requestVote(VoteRequest request, RpcCallback<VoteResponse> callback);

    Future<AppendEntriesResponse> appendEntries(AppendEntriesRequest request, RpcCallback<AppendEntriesResponse> callback);
}
