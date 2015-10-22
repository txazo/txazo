package org.txazo.java.concurrency.extension;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 同步屏障
 *
 * @author xiaozhou.tu
 * @date 2015-10-22
 * @see java.util.concurrent.CyclicBarrier
 */
public class CyclicBarrierTest {

    @Test
    public void test() throws BrokenBarrierException, InterruptedException {
        final CyclicBarrier barrier = new CyclicBarrier(10, new BarrierCallback());
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        barrier.await();
    }

    private static class BarrierCallback implements Runnable {

        @Override
        public void run() {
            System.out.println("BarrierCallback begin");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("BarrierCallback end");
        }

    }

}
