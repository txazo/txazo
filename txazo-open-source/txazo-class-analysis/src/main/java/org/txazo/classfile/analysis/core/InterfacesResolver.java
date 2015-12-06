package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

import java.util.ArrayList;
import java.util.List;

public class InterfacesResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) throws Exception {
        short interfacesCount = context.getInterfacesCount();
        List<String> interfaces = new ArrayList<String>();
        for (int i = 0; i < interfacesCount; i++) {
            interfaces.add(context.getClassNameFromConstantPool(reader.readShort()));
        }
        return new Interfaces(interfaces);
    }

    private static class Interfaces extends ClassStruct {

        private List<String> interfaces;

        public Interfaces(List<String> interfaces) {
            this.interfaces = interfaces;
        }

        public List<String> getInterfaces() {
            return interfaces;
        }

    }

}
