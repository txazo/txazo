package org.txazo.monitor.common.util;

/**
 * ByteUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public abstract class ByteUtils {

    private static final long BYTE_UNIT_1 = 1 << 10;
    private static final long BYTE_UNIT_2 = 1 << 20;
    private static final long BYTE_UNIT_3 = 1 << 30;

    public static long getKByte(long bytes) {
        return bytes / BYTE_UNIT_1;
    }

    public static long getMByte(long bytes) {
        return bytes / BYTE_UNIT_2;
    }

    public static long getMByteFromKByte(long bytes) {
        return bytes / BYTE_UNIT_1;
    }

    public static long getGByte(long bytes) {
        return bytes / BYTE_UNIT_3;
    }

    public static long getGByteFromKByte(long bytes) {
        return bytes / BYTE_UNIT_2;
    }

    public static long getGByteFromMByte(long bytes) {
        return bytes / BYTE_UNIT_1;
    }

}
