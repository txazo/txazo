package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class FieldsCountResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) throws Exception {
        short fieldsCount = reader.readShort();
        context.setFieldsCount(fieldsCount);
        return new FieldsCount(fieldsCount);
    }

    private static class FieldsCount extends ClassStruct {

        private short fields_count;

        public FieldsCount(short fields_count) {
            this.fields_count = fields_count;
        }

        public short getFields_count() {
            return fields_count;
        }

    }

}
