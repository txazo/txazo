package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子操作类－AtomicInteger
 * <p/>
 * 1) long valueOffset(value的内存偏移)
 * 2) volatile int value
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicInteger
 * @see AtomicInteger#value
 * @see AtomicInteger#valueOffset
 * @see AtomicInteger#compareAndSet(int, int)
 */
public class AtomicIntegerTest {

    @Test
    public void test() {
        AtomicInteger integer = new AtomicInteger(1);
        Assert.assertEquals(1, integer.get());
        integer.set(10);
        Assert.assertEquals(10, integer.get());
        Assert.assertTrue(integer.compareAndSet(10, 100));
        Assert.assertEquals(100, integer.get());
    }

}
