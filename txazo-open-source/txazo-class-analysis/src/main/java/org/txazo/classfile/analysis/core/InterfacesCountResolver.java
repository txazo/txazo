package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class InterfacesCountResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) throws Exception {
        short interfacesCount = reader.readShort();
        context.setInterfacesCount(interfacesCount);
        return new InterfacesCount(interfacesCount);
    }

    private static class InterfacesCount extends ClassStruct {

        private short interfaces_count;

        public InterfacesCount(short interfaces_count) {
            this.interfaces_count = interfaces_count;
        }

        public short getInterfaces_count() {
            return interfaces_count;
        }

    }

}
