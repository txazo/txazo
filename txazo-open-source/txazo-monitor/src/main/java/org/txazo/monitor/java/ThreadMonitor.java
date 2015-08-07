package org.txazo.monitor.java;

import org.txazo.monitor.mx.MXBeanFactory;

/**
 * ThreadMonitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public abstract class ThreadMonitor {

    /** Live Daemon and User Thread count */
    public static long getThreadCount() {
        return MXBeanFactory.getThreadMXBean().getThreadCount();
    }

    /** Live Daemon Thread count */
    public static long getDaemonThreadCount() {
        return MXBeanFactory.getThreadMXBean().getDaemonThreadCount();
    }

    /** Live User Thread count */
    public static long getUserThreadCount() {
        return getThreadCount() - getDaemonThreadCount();
    }

    /** the max Live Thread count */
    public static long getPeakThreadCount() {
        return MXBeanFactory.getThreadMXBean().getPeakThreadCount();
    }

    /** the total Started Thread count */
    public static long getTotalStartedThreadCount() {
        return MXBeanFactory.getThreadMXBean().getTotalStartedThreadCount();
    }

}
