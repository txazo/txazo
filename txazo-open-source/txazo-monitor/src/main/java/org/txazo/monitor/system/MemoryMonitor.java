package org.txazo.monitor.system;

import org.txazo.monitor.common.util.ByteUtils;
import org.txazo.monitor.mx.MXBeanFactory;

/**
 * MemoryMonitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public abstract class MemoryMonitor {

    /** FreePhysicalMemory */
    public static long getFreePhysicalMemory() {
        return ByteUtils.getMByte(MXBeanFactory.getOperatingSystemMXBean().getFreePhysicalMemorySize());
    }

    /* FreeSwapSpace */
    public static long getFreeSwapSpace() {
        return ByteUtils.getMByte(MXBeanFactory.getOperatingSystemMXBean().getFreeSwapSpaceSize());
    }

}
