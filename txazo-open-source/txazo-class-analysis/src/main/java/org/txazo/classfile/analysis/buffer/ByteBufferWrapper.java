package org.txazo.classfile.analysis.buffer;

import java.nio.ByteBuffer;

public class ByteBufferWrapper {

    private ByteBuffer byteBuffer;

    public ByteBufferWrapper(byte[] bytes) {
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
