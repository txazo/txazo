package org.txazo.monitor.java;

import org.txazo.monitor.mx.MXBeanFactory;

import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadDump {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = MXBeanFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo);
        }
    }

}
