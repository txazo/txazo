package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class SuperClassResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) throws Exception {
        short classIndex = reader.readShort();
        String className = context.getClassNameFromConstantPool(classIndex);
        return new SuperClass("#" + classIndex + " " + className);
    }

    private static class SuperClass extends ClassStruct {

        private String super_class;

        public SuperClass(String super_class) {
            this.super_class = super_class;
        }

        public String getSuper_class() {
            return super_class;
        }

    }

}
