package org.txazo.java.concurrency.thread;

import org.junit.Test;

/**
 * InterruptTest
 *
 * @author xiaozhou.tu
 * @date 2015-10-07
 */
public class InterruptTest {

    @Test
    public void test1() throws InterruptedException {
        Interrupt1 interrupt = new Interrupt1();
        new Thread(interrupt).start();
        Thread.sleep(100);
        interrupt.cancel();
        Thread.sleep(1000);
    }

    @Test
    public void test2() throws InterruptedException {
        Thread thread = new Thread(new Interrupt2());
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        Thread.sleep(1000);
    }

    @Test
    public void test3() throws InterruptedException {
        Thread thread = new Thread(new Interrupt3());
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        Thread.sleep(1000);
    }

    /**
     * 线程中断方式一: volatile变量
     */
    private static class Interrupt1 implements Runnable {

        private volatile boolean avaliable = true;

        @Override
        public void run() {
            int count = 0;
            while (avaliable) {
                System.out.println("count: " + count++);
            }
        }

        public void cancel() {
            avaliable = false;
        }

    }

    /**
     * 线程中断方式二: 中断信号检测
     */
    private static class Interrupt2 implements Runnable {

        @Override
        public void run() {
            int count = 0;
            while (!Thread.interrupted()) {
                System.out.println("count: " + count++);
            }
//            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println("count: " + count++);
//            }
        }

    }

    /**
     * 线程中断方式三: 异常中断
     * <p/>
     * 1) 适用于Object.wait、Thread.join、Thread.sleep等抛出InterruptedException
     */
    private static class Interrupt3 implements Runnable {

        @Override
        public void run() {
            int count = 0;
            try {
                while (true) {
                    System.out.println("count: " + count++);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
