package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.util.ByteUtils;

import java.nio.ByteBuffer;

public class ClassReader {

    private ByteBuffer byteBuffer;

    public ClassReader(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("bytes can not be null");
        }
        byteBuffer = ByteBuffer.wrap(bytes);
    }

    public byte readByte() {
        return byteBuffer.get();
    }

    public byte[] readByte(int n) {
        byte[] bytes = new byte[n];
        byteBuffer.get(bytes);
        return bytes;
    }

    public String readHex() {
        return ByteUtils.byteToHex(readByte());
    }

    public String readHex(int n) {
        return ByteUtils.byteToHex(readByte(n));
    }

    public int readInt() {
        return byteBuffer.getInt();
    }

    public short readShort() {
        return byteBuffer.getShort();
    }

}
