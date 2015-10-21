package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子操作类－AtomicLong
 * <p/>
 * 1) long valueOffset(value的内存偏移)
 * 2) volatile long value
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicLong
 * @see AtomicLong#value
 * @see AtomicLong#valueOffset
 * @see AtomicLong#compareAndSet(long, long)
 */
public class AtomicLongTest {

    @Test
    public void test() {
        AtomicLong atomicLong = new AtomicLong(1);
        Assert.assertEquals(1, atomicLong.get());
        atomicLong.set(10);
        Assert.assertEquals(10, atomicLong.get());
        Assert.assertTrue(atomicLong.compareAndSet(10, 100));
        Assert.assertEquals(100, atomicLong.get());
    }

}
