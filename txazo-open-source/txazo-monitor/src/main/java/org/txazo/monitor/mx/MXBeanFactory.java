package org.txazo.monitor.mx;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
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
        return OperatingSystemMXBeanHolder.instance;
    }

    public static ThreadMXBean getThreadMXBean() {
        return ThreadMXBeanHolder.instance;
    }

    private static class OperatingSystemMXBeanHolder {

        private static OperatingSystemMXBean instance = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    }

    private static class ThreadMXBeanHolder {

        private static ThreadMXBean instance = ManagementFactory.getThreadMXBean();
    }

}
