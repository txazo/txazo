package org.txazo.java.charset;

public abstract class ByteUtils {

    private static final char[] CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String toHex(byte... bytes) {
        char[] chars = new char[bytes.length << 1];
        for (int i = 0; i < bytes.length; i++) {
            chars[i << 1] = CHARS[(bytes[i] & 0xf0) >> 4];
            chars[(i << 1) + 1] = CHARS[(bytes[i] & 0x0f)];
        }
        return "0x" + String.valueOf(chars);
    }

}
