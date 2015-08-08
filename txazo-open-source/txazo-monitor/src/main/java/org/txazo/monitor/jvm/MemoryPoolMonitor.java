package org.txazo.monitor.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

/**
 * MemoryPoolMonitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 08.08.2015
 */
public abstract class MemoryPoolMonitor {

    public static void main(String[] args) {
        List<MemoryPoolMXBean> mpmbs = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean m : mpmbs) {
            System.out.println(m.getName());
            System.out.println(m.getType());
            System.out.println(m.getUsage());
            System.out.println(m.getPeakUsage());
            System.out.println(m.getCollectionUsage());
        }
    }

}
