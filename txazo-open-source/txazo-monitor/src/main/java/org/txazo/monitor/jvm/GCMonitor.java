package org.txazo.monitor.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by txazo on 15/8/7.
 */
public class GCMonitor {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> gcmbs = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcmb : gcmbs) {
            System.out.println(gcmb.getMemoryPoolNames());
            System.out.println(gcmb.getCollectionCount() + "\t" + gcmb.getCollectionTime());
        }
    }

}
