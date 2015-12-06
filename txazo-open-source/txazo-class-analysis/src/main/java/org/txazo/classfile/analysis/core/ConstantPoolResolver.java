package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;
import org.txazo.classfile.analysis.common.ResolverException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstantPoolResolver implements Resolver {

    private static Map<ConstantPoolTag, ConstantPoolInfoResolver> constantPoolInfoResolvers = new HashMap<ConstantPoolTag, ConstantPoolInfoResolver>();

    static {
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_Utf8, new Utf8Resolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_Integer, new IntegerResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_Float, new FloatResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_Long, new LongResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_Double, new DoubleResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_Class, new ClassResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_String, new StringResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_Fieldref, new FieldrefResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_Methodref, new MethodrefResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_InterfaceMethodref, new InterfaceMethodrefResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_NameAndType, new NameAndTypeResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_MethodHandle, new MethodHandleResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_MethodType, new MethodTypeResolver());
        constantPoolInfoResolvers.put(ConstantPoolTag.CONSTANT_InvokeDynamic, new InvokeDynamicResolver());
    }

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) {
        int constantPoolCount = context.getConstantPoolCount();
        List<ConstantPoolInfo> constantPools = new ArrayList<ConstantPoolInfo>();
        for (int i = 1; i < constantPoolCount; i++) {
            int index = reader.readByte();
            ConstantPoolTag tag = ConstantPoolTag.getConstantPoolTag(index);
            if (tag == ConstantPoolTag.CONSTANT_None) {
                throw new ResolverException("Constant pool tag is unkonwn");
            }
            ConstantPoolInfoResolver resolver = constantPoolInfoResolvers.get(tag);
            ConstantPoolInfo info = resolver.resolve(reader, tag);
            if (info == null) {
                throw new ResolverException("Constant pool tag can not be null");
            }
            constantPools.add(info);
        }
        context.setConstantPool(constantPools);
        return new ConstantPool(constantPools);
    }

    private static class ConstantPool extends ClassStruct {

        private List<ConstantPoolInfo> constantPools;

        public ConstantPool(List<ConstantPoolInfo> constantPools) {
            this.constantPools = constantPools;
        }

        public List<ConstantPoolInfo> getConstantPools() {
            return constantPools;
        }

    }

    private enum ConstantPoolTag {

        CONSTANT_None(-1),
        CONSTANT_Utf8(1),
        CONSTANT_Integer(3),
        CONSTANT_Float(4),
        CONSTANT_Long(5),
        CONSTANT_Double(6),
        CONSTANT_Class(7),
        CONSTANT_String(8),
        CONSTANT_Fieldref(9),
        CONSTANT_Methodref(10),
        CONSTANT_InterfaceMethodref(11),
        CONSTANT_NameAndType(12),
        CONSTANT_MethodHandle(15),
        CONSTANT_MethodType(16),
        CONSTANT_InvokeDynamic(18);

        private int index;

        ConstantPoolTag(int index) {
            this.index = index;
        }

        public static ConstantPoolTag getConstantPoolTag(int index) {
            for (ConstantPoolTag tag : values()) {
                if (index == tag.getIndex()) {
                    return tag;
                }
            }
            return CONSTANT_None;
        }

        public int getIndex() {
            return index;
        }

    }

    private static class ConstantPoolInfo extends ClassStruct {

        private String tag;

        public ConstantPoolInfo(ConstantPoolTag tag) {
            this.tag = tag.name();
        }

        public String getTag() {
            return tag;
        }

    }

    private static interface ConstantPoolInfoResolver {

        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag);

    }

    private static class Utf8Resolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            short length = reader.readShort();
            String bytes = new String(reader.readByte(length));
            return new ConstantUtf8Info(length, bytes, tag);
        }

        private static class ConstantUtf8Info extends ConstantPoolInfo {

            private short length;
            private String bytes;

            public ConstantUtf8Info(short length, String bytes, ConstantPoolTag tag) {
                super(tag);
                this.length = length;
                this.bytes = bytes;
            }

            public short getLength() {
                return length;
            }

            public String getBytes() {
                return bytes;
            }

        }

    }

    private static class IntegerResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantIntegerInfo(reader.readInt(), tag);
        }

        private static class ConstantIntegerInfo extends ConstantPoolInfo {

            private int bytes;

            public ConstantIntegerInfo(int bytes, ConstantPoolTag tag) {
                super(tag);
                this.bytes = bytes;
            }

            public int getBytes() {
                return bytes;
            }

        }

    }

    private static class FloatResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantFloatInfo(reader.readFloat(), tag);
        }

        private static class ConstantFloatInfo extends ConstantPoolInfo {

            private float bytes;

            public ConstantFloatInfo(float bytes, ConstantPoolTag tag) {
                super(tag);
                this.bytes = bytes;
            }

            public float getBytes() {
                return bytes;
            }

        }

    }

    private static class LongResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantLongInfo(reader.readLong(), tag);
        }

        private static class ConstantLongInfo extends ConstantPoolInfo {

            private long bytes;

            public ConstantLongInfo(long bytes, ConstantPoolTag tag) {
                super(tag);
                this.bytes = bytes;
            }

            public long getBytes() {
                return bytes;
            }

        }

    }

    private static class DoubleResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantDoubleInfo(reader.readLong(), tag);
        }

        private static class ConstantDoubleInfo extends ConstantPoolInfo {

            private double bytes;

            public ConstantDoubleInfo(double bytes, ConstantPoolTag tag) {
                super(tag);
                this.bytes = bytes;
            }

            public double getBytes() {
                return bytes;
            }

        }

    }

    private static class ClassResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantClassInfo(reader.readShort(), tag);
        }

        private static class ConstantClassInfo extends ConstantPoolInfo {

            private short name_index;

            public ConstantClassInfo(short name_index, ConstantPoolTag tag) {
                super(tag);
                this.name_index = name_index;
            }

            public short getName_index() {
                return name_index;
            }

        }

    }

    private static class StringResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantStringInfo(reader.readShort(), tag);
        }

        private static class ConstantStringInfo extends ConstantPoolInfo {

            private short string_index;

            public ConstantStringInfo(short string_index, ConstantPoolTag tag) {
                super(tag);
                this.string_index = string_index;
            }

            public short getString_index() {
                return string_index;
            }

        }

    }

    private static class FieldrefResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantFieldrefInfo(reader.readShort(), reader.readShort(), tag);
        }

        private static class ConstantFieldrefInfo extends ConstantPoolInfo {

            private short class_index;
            private short name_and_type_index;

            public ConstantFieldrefInfo(short class_index, short name_and_type_index, ConstantPoolTag tag) {
                super(tag);
                this.class_index = class_index;
                this.name_and_type_index = name_and_type_index;
            }

            public short getClass_index() {
                return class_index;
            }

            public short getName_and_type_index() {
                return name_and_type_index;
            }

        }

    }

    private static class MethodrefResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantMethodrefInfo(reader.readShort(), reader.readShort(), tag);
        }

        private static class ConstantMethodrefInfo extends ConstantPoolInfo {

            private short class_index;
            private short name_and_type_index;

            public ConstantMethodrefInfo(short class_index, short name_and_type_index, ConstantPoolTag tag) {
                super(tag);
                this.class_index = class_index;
                this.name_and_type_index = name_and_type_index;
            }

            public short getClass_index() {
                return class_index;
            }

            public short getName_and_type_index() {
                return name_and_type_index;
            }

        }

    }

    private static class InterfaceMethodrefResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantInterfaceMethodrefInfo(reader.readShort(), reader.readShort(), tag);
        }

        private static class ConstantInterfaceMethodrefInfo extends ConstantPoolInfo {

            private short class_index;
            private short name_and_type_index;

            public ConstantInterfaceMethodrefInfo(short class_index, short name_and_type_index, ConstantPoolTag tag) {
                super(tag);
                this.class_index = class_index;
                this.name_and_type_index = name_and_type_index;
            }

            public short getClass_index() {
                return class_index;
            }

            public short getName_and_type_index() {
                return name_and_type_index;
            }

        }

    }

    private static class NameAndTypeResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantNameAndTypeInfo(reader.readShort(), reader.readShort(), tag);
        }

        private static class ConstantNameAndTypeInfo extends ConstantPoolInfo {

            private short name_index;
            private short descriptor_index;

            public ConstantNameAndTypeInfo(short name_index, short descriptor_index, ConstantPoolTag tag) {
                super(tag);
                this.name_index = name_index;
                this.descriptor_index = descriptor_index;
            }

            public short getName_index() {
                return name_index;
            }

            public short getDescriptor_index() {
                return descriptor_index;
            }

        }

    }

    private static class MethodHandleResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantMethodHandleInfo(reader.readByte(), reader.readShort(), tag);
        }

        private static class ConstantMethodHandleInfo extends ConstantPoolInfo {

            private byte reference_kind;
            private short reference_index;

            public ConstantMethodHandleInfo(byte reference_kind, short reference_index, ConstantPoolTag tag) {
                super(tag);
                this.reference_kind = reference_kind;
                this.reference_index = reference_index;
            }

            public byte getReference_kind() {
                return reference_kind;
            }

            public short getReference_index() {
                return reference_index;
            }

        }

    }

    private static class MethodTypeResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantMethodTypeInfo(reader.readShort(), tag);
        }

        private static class ConstantMethodTypeInfo extends ConstantPoolInfo {

            private short descriptor_index;

            public ConstantMethodTypeInfo(short descriptor_index, ConstantPoolTag tag) {
                super(tag);
                this.descriptor_index = descriptor_index;
            }

            public short getDescriptor_index() {
                return descriptor_index;
            }

        }

    }

    private static class InvokeDynamicResolver implements ConstantPoolInfoResolver {

        @Override
        public ConstantPoolInfo resolve(ClassReader reader, ConstantPoolTag tag) {
            return new ConstantInvokeDynamicInfo(reader.readShort(), reader.readShort(), tag);
        }

        private static class ConstantInvokeDynamicInfo extends ConstantPoolInfo {

            private short bootstrap_method_attr_index;
            private short name_and_type_index;

            public ConstantInvokeDynamicInfo(short bootstrap_method_attr_index, short name_and_type_index, ConstantPoolTag tag) {
                super(tag);
                this.bootstrap_method_attr_index = bootstrap_method_attr_index;
                this.name_and_type_index = name_and_type_index;
            }

            public short getBootstrap_method_attr_index() {
                return bootstrap_method_attr_index;
            }

            public short getName_and_type_index() {
                return name_and_type_index;
            }

        }

    }


}
