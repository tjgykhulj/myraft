// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package org.github.tjg.myraft.model.proto;

public interface ServerOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.github.tjg.myraft.model.proto.Server)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 serverId = 1;</code>
   * @return The serverId.
   */
  int getServerId();

  /**
   * <code>int32 port = 2;</code>
   * @return The port.
   */
  int getPort();

  /**
   * <code>string ip = 3;</code>
   * @return The ip.
   */
  java.lang.String getIp();
  /**
   * <code>string ip = 3;</code>
   * @return The bytes for ip.
   */
  com.google.protobuf.ByteString
      getIpBytes();
}
