package org.txazo.monitor.jvm;

import org.txazo.monitor.common.util.ByteUtils;

/**
 * JVMMemoryMonitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public abstract class JVMMemoryMonitor {

    public static long getMaxMemory() {
        return ByteUtils.getMByte(Runtime.getRuntime().maxMemory());
    }

    public static long getTotalMemory() {
        return ByteUtils.getMByte(Runtime.getRuntime().totalMemory());
    }

    public static long getFreeMemory() {
        return ByteUtils.getMByte(Runtime.getRuntime().freeMemory());
    }

}
