package org.txazo.java.concurrency.thread;

import org.junit.Test;

/**
 * ThreadDaemonTest
 *
 * @author xiaozhou.tu
 * @date 2015-10-09
 */
public class ThreadDaemonTest {

    /**
     * 1) Java线程分为用户线程和守护线程
     * 2) 守护线程: 后台运行的线程
     * 3) 虚拟机中所有用户线程退出，虚拟机也会退出
     */

    @Test
    public void test() throws InterruptedException {
        Thread t = new Thread(new DaemonThread());
        // 设置线程为守护线程
        t.setDaemon(true);
        t.start();
        Thread.sleep(10);
    }

    private static class DaemonThread implements Runnable {

        @Override
        public void run() {
            int count = 0;
            try {
                while (true) {
                    System.out.println("DaemonThread running " + count++);
                }
            } catch (Exception e) {
                // 不会执行
                e.printStackTrace();
            }
        }

    }

//    源码: java.lang.Thread
//
//    public class Thread implements Runnable {
//
//        // 守护线程标识
//        private boolean daemon = false;
//
//        public Thread() {
//            Thread parent = currentThread();
//            // 继承父线程的daemon
//            this.daemon = parent.isDaemon();
//        }
//
//    }

}
