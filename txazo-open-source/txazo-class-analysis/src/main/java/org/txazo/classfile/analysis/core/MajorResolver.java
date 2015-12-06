package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class MajorResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) {
        return new Version(reader.readShort());
    }

    private static class Version extends ClassStruct {

        private short major_version;

        public Version(short major_version) {
            this.major_version = major_version;
        }

        public short getMajor_version() {
            return major_version;
        }

    }

}
