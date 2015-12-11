package org.txazo.monitor.common.util;

/**
 * ByteUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public abstract class ByteUtils {

    private static final long BYTE_SHIFT_1 = 10;
    private static final long BYTE_SHIFT_2 = 20;
    private static final long BYTE_SHIFT_3 = 30;

    public static long getKB(long bytes) {
        return bytes >> BYTE_SHIFT_1;
    }

    public static long getMB(long bytes) {
        return bytes >> BYTE_SHIFT_2;
    }

    public static long getMBFromKB(long bytes) {
        return bytes >> BYTE_SHIFT_1;
    }

    public static long getGB(long bytes) {
        return bytes >> BYTE_SHIFT_3;
    }

    public static long getGBFromKB(long bytes) {
        return bytes >> BYTE_SHIFT_2;
    }

    public static long getGBFromMB(long bytes) {
        return bytes >> BYTE_SHIFT_1;
    }

}
