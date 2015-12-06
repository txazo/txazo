package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.util.ByteUtils;

import java.nio.ByteBuffer;

public class ClassReader {

    private ByteBuffer buffer;

    public ClassReader(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("bytes can not be null");
        }
        buffer = ByteBuffer.wrap(bytes);
    }

    public byte readByte() {
        return buffer.get();
    }

    public byte[] readByte(int n) {
        byte[] bytes = new byte[n];
        buffer.get(bytes);
        return bytes;
    }

    public String readHex() {
        return ByteUtils.byteToHex(readByte());
    }

    public String readHex(int n) {
        return ByteUtils.byteToHex(readByte(n));
    }

    public short readShort() {
        return buffer.getShort();
    }

    public int readInt() {
        return buffer.getInt();
    }

    public long readLong() {
        return buffer.getLong();
    }

    public float readFloat() {
        return buffer.getFloat();
    }

    public double readDouble() {
        return buffer.getDouble();
    }

}
