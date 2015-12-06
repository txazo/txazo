package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class ThisClassResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) throws Exception {
        short classIndex = reader.readShort();
        String className = context.getClassNameFromConstantPool(classIndex);
        return new ThisClass("#" + classIndex + " " + className);
    }

    private static class ThisClass extends ClassStruct {

        private String this_class;

        public ThisClass(String this_class) {
            this.this_class = this_class;
        }

        public String getThis_class() {
            return this_class;
        }

    }

}
