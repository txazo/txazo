package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;

/**
 * Unsafe
 *
 * 1) 定位对象的内存位置
 * 2) 修改对象中变量的值
 * 3) CAS
 * 4) 挂起与恢复线程
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see sun.misc.Unsafe
 */
public class UnsafeTest {

    @Test
    public void test() throws Exception {
        int concurrency = 10;
        final int times = 10000;
        final CountDownLatch countDown = new CountDownLatch(concurrency);
        final Counter counter = new Counter();
        for (int i = 0; i < concurrency; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i < times; i++) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter.add(1);
                    }

                    countDown.countDown();
                }

            }).start();
        }

        countDown.await();

        Assert.assertEquals(concurrency * times, counter.get());
    }

    private static class Counter {

        private volatile int count;
        private static final long valueOffset;

        static {
            try {
                valueOffset = UnsafeHolder.unsafe.objectFieldOffset(Counter.class.getDeclaredField("count"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public int get() {
            return count;
        }

        public int add(int count) {
            int oldCount;
            do {
                oldCount = get();
            } while (!UnsafeHolder.unsafe.compareAndSwapInt(this, valueOffset, oldCount, oldCount + count));
            return get();
        }

    }

    /**
     * 获取JDK的Unsafe
     */
    private static class UnsafeHolder {

        public static final Unsafe unsafe;

        static {
            try {
                Field field = Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                unsafe = (Unsafe) field.get(null);
            } catch (Exception e) {
                throw new Error(e);
            }
        }

    }

}
