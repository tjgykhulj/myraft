// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package org.github.tjg.myraft.model.proto;

/**
 * Protobuf type {@code org.github.tjg.myraft.model.proto.VoteResponse}
 */
public  final class VoteResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.github.tjg.myraft.model.proto.VoteResponse)
    VoteResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VoteResponse.newBuilder() to construct.
  private VoteResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VoteResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VoteResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VoteResponse(
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

            granted_ = input.readBool();
            break;
          }
          case 16: {

            term_ = input.readUInt64();
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
    return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.github.tjg.myraft.model.proto.VoteResponse.class, org.github.tjg.myraft.model.proto.VoteResponse.Builder.class);
  }

  public static final int GRANTED_FIELD_NUMBER = 1;
  private boolean granted_;
  /**
   * <pre>
   * 赢得了此张选票时为真
   * </pre>
   *
   * <code>bool granted = 1;</code>
   * @return The granted.
   */
  public boolean getGranted() {
    return granted_;
  }

  public static final int TERM_FIELD_NUMBER = 2;
  private long term_;
  /**
   * <pre>
   * 对端当前任期号
   * </pre>
   *
   * <code>uint64 term = 2;</code>
   * @return The term.
   */
  public long getTerm() {
    return term_;
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
    if (granted_ != false) {
      output.writeBool(1, granted_);
    }
    if (term_ != 0L) {
      output.writeUInt64(2, term_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (granted_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, granted_);
    }
    if (term_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, term_);
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
    if (!(obj instanceof org.github.tjg.myraft.model.proto.VoteResponse)) {
      return super.equals(obj);
    }
    org.github.tjg.myraft.model.proto.VoteResponse other = (org.github.tjg.myraft.model.proto.VoteResponse) obj;

    if (getGranted()
        != other.getGranted()) return false;
    if (getTerm()
        != other.getTerm()) return false;
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
    hash = (37 * hash) + GRANTED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getGranted());
    hash = (37 * hash) + TERM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTerm());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.github.tjg.myraft.model.proto.VoteResponse parseFrom(
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
  public static Builder newBuilder(org.github.tjg.myraft.model.proto.VoteResponse prototype) {
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
   * Protobuf type {@code org.github.tjg.myraft.model.proto.VoteResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.github.tjg.myraft.model.proto.VoteResponse)
      org.github.tjg.myraft.model.proto.VoteResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.github.tjg.myraft.model.proto.VoteResponse.class, org.github.tjg.myraft.model.proto.VoteResponse.Builder.class);
    }

    // Construct using org.github.tjg.myraft.model.proto.VoteResponse.newBuilder()
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
      granted_ = false;

      term_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.github.tjg.myraft.model.proto.Common.internal_static_org_github_tjg_myraft_model_proto_VoteResponse_descriptor;
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.VoteResponse getDefaultInstanceForType() {
      return org.github.tjg.myraft.model.proto.VoteResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.VoteResponse build() {
      org.github.tjg.myraft.model.proto.VoteResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.github.tjg.myraft.model.proto.VoteResponse buildPartial() {
      org.github.tjg.myraft.model.proto.VoteResponse result = new org.github.tjg.myraft.model.proto.VoteResponse(this);
      result.granted_ = granted_;
      result.term_ = term_;
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
      if (other instanceof org.github.tjg.myraft.model.proto.VoteResponse) {
        return mergeFrom((org.github.tjg.myraft.model.proto.VoteResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.github.tjg.myraft.model.proto.VoteResponse other) {
      if (other == org.github.tjg.myraft.model.proto.VoteResponse.getDefaultInstance()) return this;
      if (other.getGranted() != false) {
        setGranted(other.getGranted());
      }
      if (other.getTerm() != 0L) {
        setTerm(other.getTerm());
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
      org.github.tjg.myraft.model.proto.VoteResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.github.tjg.myraft.model.proto.VoteResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean granted_ ;
    /**
     * <pre>
     * 赢得了此张选票时为真
     * </pre>
     *
     * <code>bool granted = 1;</code>
     * @return The granted.
     */
    public boolean getGranted() {
      return granted_;
    }
    /**
     * <pre>
     * 赢得了此张选票时为真
     * </pre>
     *
     * <code>bool granted = 1;</code>
     * @param value The granted to set.
     * @return This builder for chaining.
     */
    public Builder setGranted(boolean value) {
      
      granted_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 赢得了此张选票时为真
     * </pre>
     *
     * <code>bool granted = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearGranted() {
      
      granted_ = false;
      onChanged();
      return this;
    }

    private long term_ ;
    /**
     * <pre>
     * 对端当前任期号
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
     * 对端当前任期号
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
     * 对端当前任期号
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


    // @@protoc_insertion_point(builder_scope:org.github.tjg.myraft.model.proto.VoteResponse)
  }

  // @@protoc_insertion_point(class_scope:org.github.tjg.myraft.model.proto.VoteResponse)
  private static final org.github.tjg.myraft.model.proto.VoteResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.github.tjg.myraft.model.proto.VoteResponse();
  }

  public static org.github.tjg.myraft.model.proto.VoteResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VoteResponse>
      PARSER = new com.google.protobuf.AbstractParser<VoteResponse>() {
    @java.lang.Override
    public VoteResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VoteResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VoteResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VoteResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.github.tjg.myraft.model.proto.VoteResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

