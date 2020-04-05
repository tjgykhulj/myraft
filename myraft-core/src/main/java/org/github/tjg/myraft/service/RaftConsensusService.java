package org.github.tjg.myraft.service;

import org.github.tjg.myraft.model.proto.AppendEntriesRequest;
import org.github.tjg.myraft.model.proto.AppendEntriesResponse;
import org.github.tjg.myraft.model.proto.VoteRequest;
import org.github.tjg.myraft.model.proto.VoteResponse;

/**
 * raft节点之间相互通信的接口。
 */
public interface RaftConsensusService {

    VoteResponse preVote(VoteRequest request);

    VoteResponse requestVote(VoteRequest request);

    AppendEntriesResponse appendEntries(AppendEntriesRequest request);
}
