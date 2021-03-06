// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package org.github.tjg.myraft.model.proto;

/**
 * Protobuf type {@code org.github.tjg.myraft.model.proto.AppendEntriesResponse}
 */
public  final class AppendEntriesResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.github.tjg.myraft.model.proto.AppendEntriesResponse)
    AppendEntriesResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AppendEntriesResponse.newBuilder() to construct.
  private AppendEntriesResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AppendEntriesResponse() {
    resCode_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AppendEntriesResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AppendEntriesResponse(
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
            int rawValue = input.readEnum();

            resCode_ = rawValue;
            break;
          }
          case 16: {

            term_ = input.readUInt64();
            break;
          }
          case 24: {

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
    return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_AppendEntriesResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_AppendEntriesResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.github.tjg.myraft.model.proto.AppendEntriesResponse.class, org.github.tjg.myraft.model.proto.AppendEntriesResponse.Builder.class);
  }

  public static final int RES_CODE_FIELD_NUMBER = 1;
  private int resCode_;
  /**
   * <pre>
   * 跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
   * </pre>
   *
   * <code>.org.github.tjg.myraft.model.proto.ResCode res_code = 1;</code>
   * @return The enum numeric value on the wire for resCode.
   */
  public int getResCodeValue() {
    return resCode_;
  }
  /**
   * <pre>
   * 跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
   * </pre>
   *
   * <code>.org.github.tjg.myraft.model.proto.ResCode res_code = 1;</code>
   * @return The resCode.
   */
  public org.github.tjg.myraft.model.proto.ResCode getResCode() {
    @SuppressWarnings("deprecation")
    org.github.tjg.myraft.model.proto.ResCode result = org.github.tjg.myraft.model.proto.ResCode.valueOf(resCode_);
    return result == null ? org.github.tjg.myraft.model.proto.ResCode.UNRECOGNIZED : result;
  }

  public static final int TERM_FIELD_NUMBER = 2;
  private long term_;
  /**
   * <pre>
   * 当前的任期号，用于领导人去更新自己
   * </pre>
   *
   * <code>uint64 term = 2;</code>
   * @return The term.
   */
  public long getTerm() {
    return term_;
  }

  public static final int LAST_LOG_INDEX_FIELD_NUMBER = 3;
  private long lastLogIndex_;
  /**
   * <code>uint64 last_log_index = 3;</code>
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
    if (resCode_ != org.github.tjg.myraft.model.proto.ResCode.RES_CODE_SUCCESS.getNumber()) {
      output.writeEnum(1, resCode_);
    }
    if (term_ != 0L) {
      output.writeUInt64(2, term_);
    }
    if (lastLogIndex_ != 0L) {
      output.writeUInt64(3, lastLogIndex_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (resCode_ != org.github.tjg.myraft.model.proto.ResCode.RES_CODE_SUCCESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, resCode_);
    }
    if (term_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, term_);
    }
    if (lastLogIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, lastLogIndex_);
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
    if (!(obj instanceof org.github.tjg.myraft.model.proto.AppendEntriesResponse)) {
      return super.equals(obj);
    }
    org.github.tjg.myraft.model.proto.AppendEntriesResponse other = (org.github.tjg.myraft.model.proto.AppendEntriesResponse) obj;

    if (resCode_ != other.resCode_) return false;
    if (getTerm()
        != other.getTerm()) return false;
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
    hash = (37 * hash) + RES_CODE_FIELD_NUMBER;
    hash = (53 * hash) + resCode_;
    hash = (37 * hash) + TERM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTerm());
    hash = (37 * hash) + LAST_LOG_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastLogIndex());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse parseFrom(
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
  public static Builder newBuilder(org.github.tjg.myraft.model.proto.AppendEntriesResponse prototype) {
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
   * Protobuf type {@code org.github.tjg.myraft.model.proto.AppendEntriesResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.github.tjg.myraft.model.proto.AppendEntriesResponse)
      org.github.tjg.myraft.model.proto.AppendEntriesResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_AppendEntriesResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_AppendEntriesResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.github.tjg.myraft.model.proto.AppendEntriesResponse.class, org.github.tjg.myraft.model.proto.AppendEntriesResponse.Builder.class);
    }

    // Construct using org.github.tjg.myraft.model.proto.AppendEntriesResponse.newBuilder()
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
      resCode_ = 0;

      term_ = 0L;

      lastLogIndex_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_AppendEntriesResponse_descriptor;
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.AppendEntriesResponse getDefaultInstanceForType() {
      return org.github.tjg.myraft.model.proto.AppendEntriesResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.AppendEntriesResponse build() {
      org.github.tjg.myraft.model.proto.AppendEntriesResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.AppendEntriesResponse buildPartial() {
      org.github.tjg.myraft.model.proto.AppendEntriesResponse result = new org.github.tjg.myraft.model.proto.AppendEntriesResponse(this);
      result.resCode_ = resCode_;
      result.term_ = term_;
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
      if (other instanceof org.github.tjg.myraft.model.proto.AppendEntriesResponse) {
        return mergeFrom((org.github.tjg.myraft.model.proto.AppendEntriesResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.github.tjg.myraft.model.proto.AppendEntriesResponse other) {
      if (other == org.github.tjg.myraft.model.proto.AppendEntriesResponse.getDefaultInstance()) return this;
      if (other.resCode_ != 0) {
        setResCodeValue(other.getResCodeValue());
      }
      if (other.getTerm() != 0L) {
        setTerm(other.getTerm());
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
      org.github.tjg.myraft.model.proto.AppendEntriesResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.github.tjg.myraft.model.proto.AppendEntriesResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int resCode_ = 0;
    /**
     * <pre>
     * 跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
     * </pre>
     *
     * <code>.org.github.tjg.myraft.model.proto.ResCode res_code = 1;</code>
     * @return The enum numeric value on the wire for resCode.
     */
    public int getResCodeValue() {
      return resCode_;
    }
    /**
     * <pre>
     * 跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
     * </pre>
     *
     * <code>.org.github.tjg.myraft.model.proto.ResCode res_code = 1;</code>
     * @param value The enum numeric value on the wire for resCode to set.
     * @return This builder for chaining.
     */
    public Builder setResCodeValue(int value) {
      resCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
     * </pre>
     *
     * <code>.org.github.tjg.myraft.model.proto.ResCode res_code = 1;</code>
     * @return The resCode.
     */
    public org.github.tjg.myraft.model.proto.ResCode getResCode() {
      @SuppressWarnings("deprecation")
      org.github.tjg.myraft.model.proto.ResCode result = org.github.tjg.myraft.model.proto.ResCode.valueOf(resCode_);
      return result == null ? org.github.tjg.myraft.model.proto.ResCode.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * 跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
     * </pre>
     *
     * <code>.org.github.tjg.myraft.model.proto.ResCode res_code = 1;</code>
     * @param value The resCode to set.
     * @return This builder for chaining.
     */
    public Builder setResCode(org.github.tjg.myraft.model.proto.ResCode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      resCode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
     * </pre>
     *
     * <code>.org.github.tjg.myraft.model.proto.ResCode res_code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearResCode() {
      
      resCode_ = 0;
      onChanged();
      return this;
    }

    private long term_ ;
    /**
     * <pre>
     * 当前的任期号，用于领导人去更新自己
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
     * 当前的任期号，用于领导人去更新自己
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
     * 当前的任期号，用于领导人去更新自己
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

    private long lastLogIndex_ ;
    /**
     * <code>uint64 last_log_index = 3;</code>
     * @return The lastLogIndex.
     */
    public long getLastLogIndex() {
      return lastLogIndex_;
    }
    /**
     * <code>uint64 last_log_index = 3;</code>
     * @param value The lastLogIndex to set.
     * @return This builder for chaining.
     */
    public Builder setLastLogIndex(long value) {
      
      lastLogIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 last_log_index = 3;</code>
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


    // @@protoc_insertion_point(builder_scope:org.github.tjg.myraft.model.proto.AppendEntriesResponse)
  }

  // @@protoc_insertion_point(class_scope:org.github.tjg.myraft.model.proto.AppendEntriesResponse)
  private static final org.github.tjg.myraft.model.proto.AppendEntriesResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.github.tjg.myraft.model.proto.AppendEntriesResponse();
  }

  public static org.github.tjg.myraft.model.proto.AppendEntriesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AppendEntriesResponse>
      PARSER = new com.google.protobuf.AbstractParser<AppendEntriesResponse>() {
    @java.lang.Override
    public AppendEntriesResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AppendEntriesResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AppendEntriesResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AppendEntriesResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.github.tjg.myraft.model.proto.AppendEntriesResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

