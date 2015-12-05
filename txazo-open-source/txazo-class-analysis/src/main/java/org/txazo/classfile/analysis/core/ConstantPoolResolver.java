package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

import java.util.HashMap;
import java.util.Map;

public class ConstantPoolResolver implements Resolver {

    private static Map<Integer, Resolver> constantPoolItemResolvers = new HashMap<Integer, Resolver>();

    static {
        constantPoolItemResolvers.put(1, null);
    }

    @Override
    public ClassStruct resolve(ClassReader classReader, ClassContext classContext) {
        short constantPoolCount = classContext.getConstantPoolCount();
        return new ConstantPool();
    }

    private static class Utf8Resolver implements Resolver {

        @Override
        public ClassStruct resolve(ClassReader classReader, ClassContext classContext) {
            short length = classReader.readShort();
            String bytes = new String(classReader.readByte(length));
            return new Utf8(length, bytes);
        }

        private static class Utf8 extends ClassStruct {

            private short length;
            private String bytes;

            public Utf8(short length, String bytes) {
                this.length = length;
                this.bytes = bytes;
            }

            public short getLength() {
                return length;
            }

            public String getBytes() {
                return bytes;
            }

        }

    }

    private static class ConstantPool extends ClassStruct {


    }

}
