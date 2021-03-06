// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package org.github.tjg.myraft.model.proto;

/**
 * Protobuf type {@code org.github.tjg.myraft.model.proto.VoteRequest}
 */
public  final class VoteRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.github.tjg.myraft.model.proto.VoteRequest)
    VoteRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VoteRequest.newBuilder() to construct.
  private VoteRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VoteRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VoteRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VoteRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            serverId_ = input.readUInt32();
            break;
          }
          case 16: {

            term_ = input.readUInt64();
            break;
          }
          case 24: {

            lastLogTerm_ = input.readUInt64();
            break;
          }
          case 32: {

            lastLogIndex_ = input.readUInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.github.tjg.myraft.model.proto.VoteRequest.class, org.github.tjg.myraft.model.proto.VoteRequest.Builder.class);
  }

  public static final int SERVER_ID_FIELD_NUMBER = 1;
  private int serverId_;
  /**
   * <pre>
   * 请求选票的候选人的 Id
   * </pre>
   *
   * <code>uint32 server_id = 1;</code>
   * @return The serverId.
   */
  public int getServerId() {
    return serverId_;
  }

  public static final int TERM_FIELD_NUMBER = 2;
  private long term_;
  /**
   * <pre>
   * 候选人的任期号
   * </pre>
   *
   * <code>uint64 term = 2;</code>
   * @return The term.
   */
  public long getTerm() {
    return term_;
  }

  public static final int LAST_LOG_TERM_FIELD_NUMBER = 3;
  private long lastLogTerm_;
  /**
   * <pre>
   * 候选人的最后日志条目的任期号
   * </pre>
   *
   * <code>uint64 last_log_term = 3;</code>
   * @return The lastLogTerm.
   */
  public long getLastLogTerm() {
    return lastLogTerm_;
  }

  public static final int LAST_LOG_INDEX_FIELD_NUMBER = 4;
  private long lastLogIndex_;
  /**
   * <pre>
   * 候选人最后日志条目的索引值
   * </pre>
   *
   * <code>uint64 last_log_index = 4;</code>
   * @return The lastLogIndex.
   */
  public long getLastLogIndex() {
    return lastLogIndex_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (serverId_ != 0) {
      output.writeUInt32(1, serverId_);
    }
    if (term_ != 0L) {
      output.writeUInt64(2, term_);
    }
    if (lastLogTerm_ != 0L) {
      output.writeUInt64(3, lastLogTerm_);
    }
    if (lastLogIndex_ != 0L) {
      output.writeUInt64(4, lastLogIndex_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (serverId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, serverId_);
    }
    if (term_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, term_);
    }
    if (lastLogTerm_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, lastLogTerm_);
    }
    if (lastLogIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(4, lastLogIndex_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.github.tjg.myraft.model.proto.VoteRequest)) {
      return super.equals(obj);
    }
    org.github.tjg.myraft.model.proto.VoteRequest other = (org.github.tjg.myraft.model.proto.VoteRequest) obj;

    if (getServerId()
        != other.getServerId()) return false;
    if (getTerm()
        != other.getTerm()) return false;
    if (getLastLogTerm()
        != other.getLastLogTerm()) return false;
    if (getLastLogIndex()
        != other.getLastLogIndex()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SERVER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getServerId();
    hash = (37 * hash) + TERM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTerm());
    hash = (37 * hash) + LAST_LOG_TERM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastLogTerm());
    hash = (37 * hash) + LAST_LOG_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastLogIndex());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.VoteRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.github.tjg.myraft.model.proto.VoteRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code org.github.tjg.myraft.model.proto.VoteRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.github.tjg.myraft.model.proto.VoteRequest)
      org.github.tjg.myraft.model.proto.VoteRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.github.tjg.myraft.model.proto.VoteRequest.class, org.github.tjg.myraft.model.proto.VoteRequest.Builder.class);
    }

    // Construct using org.github.tjg.myraft.model.proto.VoteRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      serverId_ = 0;

      term_ = 0L;

      lastLogTerm_ = 0L;

      lastLogIndex_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteRequest_descriptor;
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.VoteRequest getDefaultInstanceForType() {
      return org.github.tjg.myraft.model.proto.VoteRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.VoteRequest build() {
      org.github.tjg.myraft.model.proto.VoteRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.VoteRequest buildPartial() {
      org.github.tjg.myraft.model.proto.VoteRequest result = new org.github.tjg.myraft.model.proto.VoteRequest(this);
      result.serverId_ = serverId_;
      result.term_ = term_;
      result.lastLogTerm_ = lastLogTerm_;
      result.lastLogIndex_ = lastLogIndex_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.github.tjg.myraft.model.proto.VoteRequest) {
        return mergeFrom((org.github.tjg.myraft.model.proto.VoteRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.github.tjg.myraft.model.proto.VoteRequest other) {
      if (other == org.github.tjg.myraft.model.proto.VoteRequest.getDefaultInstance()) return this;
      if (other.getServerId() != 0) {
        setServerId(other.getServerId());
      }
      if (other.getTerm() != 0L) {
        setTerm(other.getTerm());
      }
      if (other.getLastLogTerm() != 0L) {
        setLastLogTerm(other.getLastLogTerm());
      }
      if (other.getLastLogIndex() != 0L) {
        setLastLogIndex(other.getLastLogIndex());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.github.tjg.myraft.model.proto.VoteRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.github.tjg.myraft.model.proto.VoteRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int serverId_ ;
    /**
     * <pre>
     * 请求选票的候选人的 Id
     * </pre>
     *
     * <code>uint32 server_id = 1;</code>
     * @return The serverId.
     */
    public int getServerId() {
      return serverId_;
    }
    /**
     * <pre>
     * 请求选票的候选人的 Id
     * </pre>
     *
     * <code>uint32 server_id = 1;</code>
     * @param value The serverId to set.
     * @return This builder for chaining.
     */
    public Builder setServerId(int value) {
      
      serverId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 请求选票的候选人的 Id
     * </pre>
     *
     * <code>uint32 server_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearServerId() {
      
      serverId_ = 0;
      onChanged();
      return this;
    }

    private long term_ ;
    /**
     * <pre>
     * 候选人的任期号
     * </pre>
     *
     * <code>uint64 term = 2;</code>
     * @return The term.
     */
    public long getTerm() {
      return term_;
    }
    /**
     * <pre>
     * 候选人的任期号
     * </pre>
     *
     * <code>uint64 term = 2;</code>
     * @param value The term to set.
     * @return This builder for chaining.
     */
    public Builder setTerm(long value) {
      
      term_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 候选人的任期号
     * </pre>
     *
     * <code>uint64 term = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTerm() {
      
      term_ = 0L;
      onChanged();
      return this;
    }

    private long lastLogTerm_ ;
    /**
     * <pre>
     * 候选人的最后日志条目的任期号
     * </pre>
     *
     * <code>uint64 last_log_term = 3;</code>
     * @return The lastLogTerm.
     */
    public long getLastLogTerm() {
      return lastLogTerm_;
    }
    /**
     * <pre>
     * 候选人的最后日志条目的任期号
     * </pre>
     *
     * <code>uint64 last_log_term = 3;</code>
     * @param value The lastLogTerm to set.
     * @return This builder for chaining.
     */
    public Builder setLastLogTerm(long value) {
      
      lastLogTerm_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 候选人的最后日志条目的任期号
     * </pre>
     *
     * <code>uint64 last_log_term = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastLogTerm() {
      
      lastLogTerm_ = 0L;
      onChanged();
      return this;
    }

    private long lastLogIndex_ ;
    /**
     * <pre>
     * 候选人最后日志条目的索引值
     * </pre>
     *
     * <code>uint64 last_log_index = 4;</code>
     * @return The lastLogIndex.
     */
    public long getLastLogIndex() {
      return lastLogIndex_;
    }
    /**
     * <pre>
     * 候选人最后日志条目的索引值
     * </pre>
     *
     * <code>uint64 last_log_index = 4;</code>
     * @param value The lastLogIndex to set.
     * @return This builder for chaining.
     */
    public Builder setLastLogIndex(long value) {
      
      lastLogIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 候选人最后日志条目的索引值
     * </pre>
     *
     * <code>uint64 last_log_index = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastLogIndex() {
      
      lastLogIndex_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:org.github.tjg.myraft.model.proto.VoteRequest)
  }

  // @@protoc_insertion_point(class_scope:org.github.tjg.myraft.model.proto.VoteRequest)
  private static final org.github.tjg.myraft.model.proto.VoteRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.github.tjg.myraft.model.proto.VoteRequest();
  }

  public static org.github.tjg.myraft.model.proto.VoteRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VoteRequest>
      PARSER = new com.google.protobuf.AbstractParser<VoteRequest>() {
    @java.lang.Override
    public VoteRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VoteRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VoteRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VoteRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.github.tjg.myraft.model.proto.VoteRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

