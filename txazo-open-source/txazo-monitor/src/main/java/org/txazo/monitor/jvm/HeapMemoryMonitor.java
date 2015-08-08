package org.txazo.monitor.jvm;

import org.txazo.monitor.common.util.ByteUtils;
import org.txazo.monitor.mx.MXBeanFactory;

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

    /** -Xms */
    public static long getInit() {
        return ByteUtils.getMByte(getHeapMemoryUsage().getInit());
    }

    /** currently used Memory */
    public static long getUsed() {
        return ByteUtils.getMByte(getHeapMemoryUsage().getUsed());
    }

    /** committed >= used */
    public static long getCommitted() {
        return ByteUtils.getMByte(getHeapMemoryUsage().getCommitted());
    }

    /** max >= committed >= used */
    public static long getMax() {
        return ByteUtils.getMByte(getHeapMemoryUsage().getMax());
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
