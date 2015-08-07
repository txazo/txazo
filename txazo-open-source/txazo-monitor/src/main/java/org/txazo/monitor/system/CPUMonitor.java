package org.txazo.monitor.system;

import org.txazo.monitor.mx.MXBeanFactory;

/**
 * CPUMonitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public class CPUMonitor {

    public static double getLoadAverage() {
        return MXBeanFactory.getOperatingSystemMXBean().getSystemLoadAverage() / availableProcessors();
    }

    public static double getUsage() {
        return CPU.getUsage() / availableProcessors();
    }

    public static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static class CPU {

        private static volatile double usage;
        private static long lastCPUTime = 0L;
        private static long lastSystemTime = 0L;

        private static double getUsage() {
            return usage;
        }

        private static void computeUsage() {
            long cpuTime = MXBeanFactory.getOperatingSystemMXBean().getProcessCpuTime();
            long systemTime = System.nanoTime();
            usage = (cpuTime - lastCPUTime) * 100 / (systemTime - lastSystemTime);
            lastCPUTime = cpuTime;
            lastSystemTime = systemTime;
        }

    }

    static {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        CPU.computeUsage();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }
            }

        }).start();
    }

}
