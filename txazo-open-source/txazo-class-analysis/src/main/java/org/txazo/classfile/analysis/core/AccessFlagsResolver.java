package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

import java.util.ArrayList;
import java.util.List;

public class AccessFlagsResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) {
        short accessFlag = reader.readShort();
        List<String> accessFlags = new ArrayList<String>();
        for (AccessFlag flag : AccessFlag.values()) {
            if (flag.match(accessFlag)) {
                accessFlags.add(flag.name());
            }
        }
        return new AccessFlags(accessFlags.toArray(new String[0]));
    }

    private enum AccessFlag {

        ACC_PUBLIC(0x0001),
        ACC_FINAL(0x0010),
        ACC_SUPER(0x0020),
        ACC_INTERFACE(0x0200),
        ACC_ABSTRACT(0x0400),
        ACC_SYNTHETIC(0x1000),
        ACC_ANNOTATION(0x2000),
        ACC_ENUM(0x4000);

        private int flag;

        AccessFlag(int flag) {
            this.flag = flag;
        }

        public boolean match(int flag) {
            return (this.flag & flag) == this.flag;
        }

        public int getFlag() {
            return flag;
        }

    }

    private static class AccessFlags extends ClassStruct {

        private String[] access_flags;

        public AccessFlags(String[] access_flags) {
            this.access_flags = access_flags;
        }

        public String[] getAccess_flags() {
            return access_flags;
        }

    }

}
