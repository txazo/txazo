package org.txazo.java.concurrency.thread;

/**
 * 线程中断
 * <p/>
 * 1) 中断: 线程的一个标识
 * 2) Thread.interrupt(): 设置中断标识为true
 * 3) Thread.interrupted(): 中断标识是否为true, 并复位中断标识为false
 * 4) Thread.isInterrupted(): 中断标识是否为true
 * 5) Object.wait()、Thread.join()、Thread.sleep(): 设置中断标识为false, 抛出InterruptedException
 *
 * @author xiaozhou.tu
 * @date 2015-10-09
 * @see java.lang.Thread#interrupt()
 * @see java.lang.Thread#interrupted()
 * @see java.lang.Thread#isInterrupted()
 * @see java.lang.InterruptedException
 */
public class InterruptTest {

    /**
     * 线程中断方式一: volatile变量
     */
    private static class Interrupt1 implements Runnable {

        private volatile boolean avaliable = true;

        @Override
        public void run() {
            while (avaliable) {
            }
        }

        public void cancel() {
            avaliable = false;
        }

    }

    /**
     * 线程中断方式二: 中断标识检测
     */
    private static class Interrupt2 implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
            }
//            while (!Thread.currentThread().isInterrupted()) {
//            }
        }

    }

    /**
     * 线程中断方式三: 中断异常捕获
     * <p/>
     * 1) 适用于Object.wait、Thread.join、Thread.sleep等抛出InterruptedException
     */
    private static class Interrupt3 implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 综合上述中断方式
     */
    private static class Interrupt4 implements Runnable {

        private volatile boolean avaliable = true;

        @Override
        public void run() {
            try {
                while (avaliable && !Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                /** 重新设置中断标识 */
                Thread.currentThread().interrupt();
            }
        }

        public void cancel() {
            avaliable = false;
        }

    }

}
