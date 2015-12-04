package org.txazo.classfile.analysis.core;

import java.nio.ByteBuffer;

public class ClassReader {

    private ByteBuffer byteBuffer;

    public ClassReader(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("bytes can not be null");
        }
        byteBuffer = ByteBuffer.wrap(bytes);
    }

    public byte read() {
        return byteBuffer.get();
    }

    public short readShort() {
        return byteBuffer.getShort();
    }

    public long readInt() {
        return byteBuffer.getInt();
    }

}
