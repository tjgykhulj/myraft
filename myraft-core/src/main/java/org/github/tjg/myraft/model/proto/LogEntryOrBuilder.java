// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package org.github.tjg.myraft.model.proto;

public interface LogEntryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.github.tjg.myraft.model.proto.LogEntry)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 term = 1;</code>
   * @return The term.
   */
  long getTerm();

  /**
   * <code>uint64 index = 2;</code>
   * @return The index.
   */
  long getIndex();

  /**
   * <code>.org.github.tjg.myraft.model.proto.EntryType type = 3;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.org.github.tjg.myraft.model.proto.EntryType type = 3;</code>
   * @return The type.
   */
  org.github.tjg.myraft.model.proto.EntryType getType();

  /**
   * <code>bytes data = 4;</code>
   * @return The data.
   */
  com.google.protobuf.ByteString getData();
}
