package org.txazo.java.optimize.jvm;

import org.junit.Test;
import org.txazo.util.time.TimeWatch;
import org.txazo.util.time.TimeWatchTask;

import java.util.concurrent.atomic.AtomicLong;

/**
 * False Sharing伪共享
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 2015-08-31
 */
public class FalseSharingTest {

    private static final int COUNT = 100000000;

    @Test
    public void test() throws Throwable {
        TimeWatch timeWatch = new TimeWatch();
        timeWatch.watch("FalseSharing", new TimeWatchTask() {

            @Override
            public void execute() {
                try {
                    Thread[] threads = new Thread[10];
                    for (int i = 0; i < threads.length; i++) {
                        threads[i] = new Thread(new FalseSharing());
                    }
                    for (Thread thread : threads) {
                        thread.start();
                    }
                    for (Thread thread : threads) {
                        thread.join();
                    }
                } catch (Exception e) {
                }
            }

        });
        timeWatch.watch("NoneFalseSharing", new TimeWatchTask() {

            @Override
            public void execute() {
                try {
                    Thread[] threads = new Thread[10];
                    for (int i = 0; i < threads.length; i++) {
                        threads[i] = new Thread(new NoneFalseSharing());
                    }
                    for (Thread thread : threads) {
                        thread.start();
                    }
                    for (Thread thread : threads) {
                        thread.join();
                    }
                } catch (Exception e) {
                }
            }

        });
        timeWatch.showTime();
    }

    private static class FalseSharing implements Runnable {

        private static AtomicLong[] longs = new AtomicLong[10];

        static {
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new AtomicLong();
            }
        }

        @Override
        public void run() {
            int count = COUNT;
            while (--count > 0) {
                longs[count % longs.length].set(count);
            }
        }

    }

    private static class NoneFalseSharing implements Runnable {

        private static PaddingAtomicLong[] longs = new PaddingAtomicLong[10];

        static {
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new PaddingAtomicLong();
            }
        }

        @Override
        public void run() {
            int count = COUNT;
            while (--count > 0) {
                longs[count % longs.length].set(count);
            }
        }

    }

    private static class PaddingAtomicLong extends AtomicLong {

        public volatile long p1, p2, p3, p4, p5, p6 = 7L;

    }

}
