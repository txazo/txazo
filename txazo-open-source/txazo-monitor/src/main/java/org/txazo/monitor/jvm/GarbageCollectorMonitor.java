package org.txazo.monitor.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GarbageCollectorMonitor {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> gcmbs = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcbm : gcmbs) {
            System.out.println(gcbm.getName());
            System.out.println(gcbm.getCollectionTime());
            System.out.println(gcbm.getCollectionCount());
        }
    }

}
