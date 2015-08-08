package org.txazo.monitor.jvm;

import org.txazo.monitor.common.util.ByteUtils;
import org.txazo.monitor.mx.MXBeanFactory;

import java.lang.management.MemoryUsage;

/**
 * NonHeapMemoryMonitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public class NonHeapMemoryMonitor {

    /** -Xms */
    public static long getInit() {
        return ByteUtils.getMByte(getNonHeapMemoryUsage().getInit());
    }

    /** currently used Memory */
    public static long getUsed() {
        return ByteUtils.getMByte(getNonHeapMemoryUsage().getUsed());
    }

    /** committed >= used */
    public static long getCommitted() {
        return ByteUtils.getMByte(getNonHeapMemoryUsage().getCommitted());
    }

    /** max >= committed >= used */
    public static long getMax() {
        return ByteUtils.getMByte(getNonHeapMemoryUsage().getMax());
    }

    private static MemoryUsage getNonHeapMemoryUsage() {
        return MXBeanFactory.getMemoryMXBean().getNonHeapMemoryUsage();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(NonHeapMemoryMonitor.getInit());
        System.out.println(NonHeapMemoryMonitor.getUsed());
        System.out.println(NonHeapMemoryMonitor.getCommitted());
        System.out.println(NonHeapMemoryMonitor.getMax());
    }

}
