package org.txazo.monitor.system;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * Created by txazo on 15/8/6.
 */
public class MemoryMonitor {

    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("Init\t\t" + memoryUsage.getInit());
        System.out.println("Max\t\t\t" + memoryUsage.getMax());
        System.out.println("Used\t\t" + memoryUsage.getUsed());
        System.out.println("Commited\t" + memoryUsage.getCommitted());
    }

}
