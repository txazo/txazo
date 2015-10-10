package org.txazo.java.concurrency.thread;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Stack;

/**
 * 等待/通知
 * <p/>
 * 1) Object.wait(): 线程在目标对象上进入等待状态
 * 2) Object.notify(): 唤醒目标对象上的一个等待线程
 * 3) Object.notifyAll(): 唤醒目标对象上的所有等待线程
 * 4) 使用wait()、notify()、notifyAll()时要先对目标对象加锁
 *
 * @author xiaozhou.tu
 * @date 2015-10-10
 * @see java.lang.Object#wait()
 * @see java.lang.Object#notify()
 * @see java.lang.Object#notifyAll()
 */
public class WaitNotifyTest {

    private static volatile boolean running = true;

    @Test
    public void test() throws InterruptedException {
        Product product = new Product();
        Thread put = new Thread(new PutThread(product));
        Thread get = new Thread(new GetThread(product));
        put.start();
        get.start();
        Thread.sleep(300000);
    }

    private static class Product {

        private static final int MAX = 5;
        private Stack<String> container = new Stack<String>();

        public synchronized void put(String p) {
            if (container.size() >= MAX) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            container.push(p);
            notify();
        }

        public synchronized String get() {
            if (container.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notify();
            return container.pop();
        }

    }

    private static class PutThread implements Runnable {

        private Product product;

        public PutThread(Product product) {
            this.product = product;
        }

        @Override
        public void run() {
            while (running) {
                String p = String.valueOf(RandomUtils.nextInt(1, 100));
                System.out.println("put " + p);
                product.put(p);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static class GetThread implements Runnable {

        private Product product;

        public GetThread(Product product) {
            this.product = product;
        }

        @Override
        public void run() {
            while (running) {
                System.out.println("get " + product.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
