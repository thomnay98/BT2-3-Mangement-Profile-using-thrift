/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2022-11-02")
public class StatusError extends org.apache.thrift.TException implements org.apache.thrift.TBase<StatusError, StatusError._Fields>, java.io.Serializable, Cloneable, Comparable<StatusError> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StatusError");

  private static final org.apache.thrift.protocol.TField ERR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("errCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ERR_MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("errMessage", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField USER_FIELD_DESC = new org.apache.thrift.protocol.TField("user", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new StatusErrorStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new StatusErrorTupleSchemeFactory();

  public int errCode; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String errMessage; // required
  public @org.apache.thrift.annotation.Nullable User user; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ERR_CODE((short)1, "errCode"),
    ERR_MESSAGE((short)2, "errMessage"),
    USER((short)3, "user");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ERR_CODE
          return ERR_CODE;
        case 2: // ERR_MESSAGE
          return ERR_MESSAGE;
        case 3: // USER
          return USER;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ERRCODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERR_CODE, new org.apache.thrift.meta_data.FieldMetaData("errCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ERR_MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("errMessage", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER, new org.apache.thrift.meta_data.FieldMetaData("user", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, User.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StatusError.class, metaDataMap);
  }

  public StatusError() {
  }

  public StatusError(
    int errCode,
    java.lang.String errMessage,
    User user)
  {
    this();
    this.errCode = errCode;
    setErrCodeIsSet(true);
    this.errMessage = errMessage;
    this.user = user;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StatusError(StatusError other) {
    __isset_bitfield = other.__isset_bitfield;
    this.errCode = other.errCode;
    if (other.isSetErrMessage()) {
      this.errMessage = other.errMessage;
    }
    if (other.isSetUser()) {
      this.user = new User(other.user);
    }
  }

  public StatusError deepCopy() {
    return new StatusError(this);
  }

  @Override
  public void clear() {
    setErrCodeIsSet(false);
    this.errCode = 0;
    this.errMessage = null;
    this.user = null;
  }

  public int getErrCode() {
    return this.errCode;
  }

  public StatusError setErrCode(int errCode) {
    this.errCode = errCode;
    setErrCodeIsSet(true);
    return this;
  }

  public void unsetErrCode() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ERRCODE_ISSET_ID);
  }

  /** Returns true if field errCode is set (has been assigned a value) and false otherwise */
  public boolean isSetErrCode() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ERRCODE_ISSET_ID);
  }

  public void setErrCodeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ERRCODE_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getErrMessage() {
    return this.errMessage;
  }

  public StatusError setErrMessage(@org.apache.thrift.annotation.Nullable java.lang.String errMessage) {
    this.errMessage = errMessage;
    return this;
  }

  public void unsetErrMessage() {
    this.errMessage = null;
  }

  /** Returns true if field errMessage is set (has been assigned a value) and false otherwise */
  public boolean isSetErrMessage() {
    return this.errMessage != null;
  }

  public void setErrMessageIsSet(boolean value) {
    if (!value) {
      this.errMessage = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public User getUser() {
    return this.user;
  }

  public StatusError setUser(@org.apache.thrift.annotation.Nullable User user) {
    this.user = user;
    return this;
  }

  public void unsetUser() {
    this.user = null;
  }

  /** Returns true if field user is set (has been assigned a value) and false otherwise */
  public boolean isSetUser() {
    return this.user != null;
  }

  public void setUserIsSet(boolean value) {
    if (!value) {
      this.user = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ERR_CODE:
      if (value == null) {
        unsetErrCode();
      } else {
        setErrCode((java.lang.Integer)value);
      }
      break;

    case ERR_MESSAGE:
      if (value == null) {
        unsetErrMessage();
      } else {
        setErrMessage((java.lang.String)value);
      }
      break;

    case USER:
      if (value == null) {
        unsetUser();
      } else {
        setUser((User)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ERR_CODE:
      return getErrCode();

    case ERR_MESSAGE:
      return getErrMessage();

    case USER:
      return getUser();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ERR_CODE:
      return isSetErrCode();
    case ERR_MESSAGE:
      return isSetErrMessage();
    case USER:
      return isSetUser();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof StatusError)
      return this.equals((StatusError)that);
    return false;
  }

  public boolean equals(StatusError that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_errCode = true;
    boolean that_present_errCode = true;
    if (this_present_errCode || that_present_errCode) {
      if (!(this_present_errCode && that_present_errCode))
        return false;
      if (this.errCode != that.errCode)
        return false;
    }

    boolean this_present_errMessage = true && this.isSetErrMessage();
    boolean that_present_errMessage = true && that.isSetErrMessage();
    if (this_present_errMessage || that_present_errMessage) {
      if (!(this_present_errMessage && that_present_errMessage))
        return false;
      if (!this.errMessage.equals(that.errMessage))
        return false;
    }

    boolean this_present_user = true && this.isSetUser();
    boolean that_present_user = true && that.isSetUser();
    if (this_present_user || that_present_user) {
      if (!(this_present_user && that_present_user))
        return false;
      if (!this.user.equals(that.user))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + errCode;

    hashCode = hashCode * 8191 + ((isSetErrMessage()) ? 131071 : 524287);
    if (isSetErrMessage())
      hashCode = hashCode * 8191 + errMessage.hashCode();

    hashCode = hashCode * 8191 + ((isSetUser()) ? 131071 : 524287);
    if (isSetUser())
      hashCode = hashCode * 8191 + user.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(StatusError other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetErrCode()).compareTo(other.isSetErrCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errCode, other.errCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetErrMessage()).compareTo(other.isSetErrMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errMessage, other.errMessage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUser()).compareTo(other.isSetUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user, other.user);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("StatusError(");
    boolean first = true;

    sb.append("errCode:");
    sb.append(this.errCode);
    first = false;
    if (!first) sb.append(", ");
    sb.append("errMessage:");
    if (this.errMessage == null) {
      sb.append("null");
    } else {
      sb.append(this.errMessage);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("user:");
    if (this.user == null) {
      sb.append("null");
    } else {
      sb.append(this.user);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (user != null) {
      user.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class StatusErrorStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public StatusErrorStandardScheme getScheme() {
      return new StatusErrorStandardScheme();
    }
  }

  private static class StatusErrorStandardScheme extends org.apache.thrift.scheme.StandardScheme<StatusError> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StatusError struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ERR_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.errCode = iprot.readI32();
              struct.setErrCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ERR_MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errMessage = iprot.readString();
              struct.setErrMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.user = new User();
              struct.user.read(iprot);
              struct.setUserIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, StatusError struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ERR_CODE_FIELD_DESC);
      oprot.writeI32(struct.errCode);
      oprot.writeFieldEnd();
      if (struct.errMessage != null) {
        oprot.writeFieldBegin(ERR_MESSAGE_FIELD_DESC);
        oprot.writeString(struct.errMessage);
        oprot.writeFieldEnd();
      }
      if (struct.user != null) {
        oprot.writeFieldBegin(USER_FIELD_DESC);
        struct.user.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StatusErrorTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public StatusErrorTupleScheme getScheme() {
      return new StatusErrorTupleScheme();
    }
  }

  private static class StatusErrorTupleScheme extends org.apache.thrift.scheme.TupleScheme<StatusError> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StatusError struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetErrCode()) {
        optionals.set(0);
      }
      if (struct.isSetErrMessage()) {
        optionals.set(1);
      }
      if (struct.isSetUser()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetErrCode()) {
        oprot.writeI32(struct.errCode);
      }
      if (struct.isSetErrMessage()) {
        oprot.writeString(struct.errMessage);
      }
      if (struct.isSetUser()) {
        struct.user.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StatusError struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.errCode = iprot.readI32();
        struct.setErrCodeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.errMessage = iprot.readString();
        struct.setErrMessageIsSet(true);
      }
      if (incoming.get(2)) {
        struct.user = new User();
        struct.user.read(iprot);
        struct.setUserIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
