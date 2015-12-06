package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class FieldsResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) throws Exception {
        short fieldsCount = context.getFieldsCount();
        for (int i = 0; i < fieldsCount; i++) {
            short accessFlags = reader.readShort();
            short nameIndex = reader.readShort();
            short descriptorIndex = reader.readShort();
            short attributesCount = reader.readShort();
        }
        return null;
    }

    private static class Fields extends ClassStruct {

    }

    private enum FieldAccess {

        ACC_PUBLIC(0x0001),
        ACC_PRIVATE(0x0002),
        ACC_PROTECTED(0x0004),
        ACC_STATIC(0x0008),
        ACC_FINAL(0x0010),
        ACC_VOLATILE(0x0040),
        ACC_TRANSIENT(0x0080),
        ACC_SYNTHETIC(0x1000),
        ACC_ENUM(0x4000);

        FieldAccess(int flag) {
            this.flag = flag;
        }

        private int flag;

        public int getFlag() {
            return flag;
        }

    }

}
