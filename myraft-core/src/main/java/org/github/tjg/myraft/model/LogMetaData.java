package org.github.tjg.myraft.model;

import lombok.Data;

@Data
public class LogMetaData {

    public static LogMetaData copy(LogMetaData src) {
        LogMetaData dst = new LogMetaData();
        if (src != null) {
            dst.setVoteFor(src.getVoteFor());
            dst.setFirstLogIndex(src.getFirstLogIndex());
            dst.setCommitIndex(src.getCommitIndex());
            dst.setCurrentTerm(src.getCurrentTerm());
        }
        return dst;
    }

    private long currentTerm;
    private int voteFor;
    private long firstLogIndex;
    private long commitIndex;
}
