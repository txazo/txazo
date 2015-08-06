package org.txazo.monitor.system;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;

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

        Runtime runtime = Runtime.getRuntime();
        System.out.println("totalMemory: " + runtime.totalMemory());
        System.out.println("maxMemory: " + runtime.maxMemory());
        System.out.println("freeMemory: " + runtime.freeMemory());
        System.out.println("cpu: " + runtime.availableProcessors());

        // 物理内存
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long totalPhysicalMemorySize = operatingSystemMXBean.getTotalPhysicalMemorySize() / 1024 / 1024;
        long freePhysicalMemorySize = operatingSystemMXBean.getFreePhysicalMemorySize() / 1024 / 1024;
        long usedPhysicalMemorySize = totalPhysicalMemorySize - freePhysicalMemorySize;
        System.out.println("总的物理内存: " + totalPhysicalMemorySize + "M");
        System.out.println("使用物理内存: " + usedPhysicalMemorySize + "M");
        System.out.println("物理内存使用率: " + usedPhysicalMemorySize * 100 / totalPhysicalMemorySize + "%");

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    }

}
