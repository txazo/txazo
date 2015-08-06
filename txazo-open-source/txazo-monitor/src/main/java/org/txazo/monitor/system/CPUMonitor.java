package org.txazo.monitor.system;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created by txazo on 15/8/6.
 */
public class CPUMonitor {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        System.out.println(threadMXBean.getCurrentThreadCpuTime());
        System.out.println(threadMXBean.getCurrentThreadUserTime());
        System.out.println(threadMXBean.getThreadCount());
        System.out.println(threadMXBean.getDaemonThreadCount());
    }

}
