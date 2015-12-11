package org.txazo.monitor.mx;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

/**
 * MXBeanFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public abstract class MXBeanFactory {

    public static OperatingSystemMXBean getOperatingSystemMXBean() {
        return (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    public static ThreadMXBean getThreadMXBean() {
        return ManagementFactory.getThreadMXBean();
    }

    public static MemoryMXBean getMemoryMXBean() {
        return ManagementFactory.getMemoryMXBean();
    }

}
