package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class MinorResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader classReader, ClassContext classContext) {
        return new Version(classReader.readShort());
    }

    private static class Version extends ClassStruct {

        private short minor_version;

        public Version(short minor_version) {
            this.minor_version = minor_version;
        }

        public int getMinor_version() {
            return minor_version;
        }

    }

}
