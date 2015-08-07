package org.txazo.monitor.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * HeapMemoryMonitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public class HeapMemoryMonitor {

    public static void main(String[] args) throws InterruptedException {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemory = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemory = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("Init\t\t" + heapMemory.getInit() / 1024 / 1024 + "M");
        System.out.println("Max\t\t\t" + heapMemory.getMax() / 1024 / 1024 + "M");
        System.out.println("Used\t\t" + heapMemory.getUsed() / 1024 / 1024 + "M");
        System.out.println("Commited\t" + heapMemory.getCommitted() / 1024 / 1024 + "M");

        System.out.println("Init\t\t" + nonHeapMemory.getInit() / 1024 / 1024 + "M");
        System.out.println("Max\t\t\t" + nonHeapMemory.getMax() / 1024 / 1024 + "M");
        System.out.println("Used\t\t" + nonHeapMemory.getUsed() / 1024 / 1024 + "M");
        System.out.println("Commited\t" + nonHeapMemory.getCommitted() / 1024 / 1024 + "M");

        Thread.sleep(1000000);
    }

}
