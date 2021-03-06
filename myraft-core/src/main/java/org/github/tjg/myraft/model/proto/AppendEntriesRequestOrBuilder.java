// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package org.github.tjg.myraft.model.proto;

public interface AppendEntriesRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.github.tjg.myraft.model.proto.AppendEntriesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 领导人的Id
   * </pre>
   *
   * <code>uint32 server_id = 1;</code>
   * @return The serverId.
   */
  int getServerId();

  /**
   * <pre>
   * 领导人的任期号
   * </pre>
   *
   * <code>uint64 term = 2;</code>
   * @return The term.
   */
  long getTerm();

  /**
   * <pre>
   * 新的日志条目紧随之前的索引值
   * </pre>
   *
   * <code>uint64 prev_log_index = 3;</code>
   * @return The prevLogIndex.
   */
  long getPrevLogIndex();

  /**
   * <pre>
   * prev_log_index条目的任期号
   * </pre>
   *
   * <code>uint64 prev_log_term = 4;</code>
   * @return The prevLogTerm.
   */
  long getPrevLogTerm();

  /**
   * <pre>
   * 领导人已经提交的日志的索引值
   * </pre>
   *
   * <code>uint64 commit_index = 5;</code>
   * @return The commitIndex.
   */
  long getCommitIndex();

  /**
   * <pre>
   * 准备存储的日志条目（表示心跳时为空）
   * </pre>
   *
   * <code>.org.github.tjg.myraft.model.proto.LogEntry entries = 6;</code>
   * @return Whether the entries field is set.
   */
  boolean hasEntries();
  /**
   * <pre>
   * 准备存储的日志条目（表示心跳时为空）
   * </pre>
   *
   * <code>.org.github.tjg.myraft.model.proto.LogEntry entries = 6;</code>
   * @return The entries.
   */
  org.github.tjg.myraft.model.proto.LogEntry getEntries();
  /**
   * <pre>
   * 准备存储的日志条目（表示心跳时为空）
   * </pre>
   *
   * <code>.org.github.tjg.myraft.model.proto.LogEntry entries = 6;</code>
   */
  org.github.tjg.myraft.model.proto.LogEntryOrBuilder getEntriesOrBuilder();
}
