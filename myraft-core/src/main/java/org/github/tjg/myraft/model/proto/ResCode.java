// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package org.github.tjg.myraft.model.proto;

/**
 * Protobuf enum {@code org.github.tjg.myraft.model.proto.ResCode}
 */
public enum ResCode
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>RES_CODE_SUCCESS = 0;</code>
   */
  RES_CODE_SUCCESS(0),
  /**
   * <code>RES_CODE_FAIL = 1;</code>
   */
  RES_CODE_FAIL(1),
  /**
   * <code>RES_CODE_NOT_LEADER = 2;</code>
   */
  RES_CODE_NOT_LEADER(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>RES_CODE_SUCCESS = 0;</code>
   */
  public static final int RES_CODE_SUCCESS_VALUE = 0;
  /**
   * <code>RES_CODE_FAIL = 1;</code>
   */
  public static final int RES_CODE_FAIL_VALUE = 1;
  /**
   * <code>RES_CODE_NOT_LEADER = 2;</code>
   */
  public static final int RES_CODE_NOT_LEADER_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static ResCode valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ResCode forNumber(int value) {
    switch (value) {
      case 0: return RES_CODE_SUCCESS;
      case 1: return RES_CODE_FAIL;
      case 2: return RES_CODE_NOT_LEADER;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ResCode>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ResCode> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ResCode>() {
          public ResCode findValueByNumber(int number) {
            return ResCode.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return org.github.tjg.myraft.model.proto.Common.getDescriptor().getEnumTypes().get(1);
  }

  private static final ResCode[] VALUES = values();

  public static ResCode valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private ResCode(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:org.github.tjg.myraft.model.proto.ResCode)
}

