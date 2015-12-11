package org.txazo.monitor.jvm;

import org.txazo.monitor.common.util.ByteUtils;
import org.txazo.monitor.mx.MXBeanFactory;

import java.lang.management.MemoryUsage;

/**
 * 堆内存监控
 */
public class HeapMemoryMonitor {

    /** -Xms */
    public static long getInit() {
        return ByteUtils.getMB(getHeapMemoryUsage().getInit());
    }

    /** currently used memory */
    public static long getUsed() {
        return ByteUtils.getMB(getHeapMemoryUsage().getUsed());
    }

    /** used <= committed */
    public static long getCommitted() {
        return ByteUtils.getMB(getHeapMemoryUsage().getCommitted());
    }

    /** used <= committed <= max */
    public static long getMax() {
        return ByteUtils.getMB(getHeapMemoryUsage().getMax());
    }

    private static MemoryUsage getHeapMemoryUsage() {
        return MXBeanFactory.getMemoryMXBean().getHeapMemoryUsage();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(HeapMemoryMonitor.getInit());
        System.out.println(HeapMemoryMonitor.getUsed());
        System.out.println(HeapMemoryMonitor.getCommitted());
        System.out.println(HeapMemoryMonitor.getMax());
    }

}
