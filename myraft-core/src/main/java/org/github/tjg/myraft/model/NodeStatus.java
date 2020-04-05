package org.github.tjg.myraft.model;

public enum NodeStatus {
    FOLLOWER,
    PRE_CANDIDATE,
    CANDIDATE,
    LEADER
}
