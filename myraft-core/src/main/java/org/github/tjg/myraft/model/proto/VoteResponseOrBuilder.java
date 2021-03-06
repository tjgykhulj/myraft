// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package org.github.tjg.myraft.model.proto;

public interface VoteResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.github.tjg.myraft.model.proto.VoteResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 赢得了此张选票时为真
   * </pre>
   *
   * <code>bool granted = 1;</code>
   * @return The granted.
   */
  boolean getGranted();

  /**
   * <pre>
   * 对端当前任期号
   * </pre>
   *
   * <code>uint64 term = 2;</code>
   * @return The term.
   */
  long getTerm();
}
