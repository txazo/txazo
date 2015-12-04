package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class ConstantPoolCountResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader) {
        return new ConstantPoolCount(reader.readShort());
    }

    private static class ConstantPoolCount extends ClassStruct {

        private short constant_pool_count;

        public ConstantPoolCount(short constant_pool_count) {
            this.constant_pool_count = constant_pool_count;
        }

        public short getConstant_pool_count() {
            return constant_pool_count;
        }

    }

}
