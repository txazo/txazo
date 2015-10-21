package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 原子操作类－AtomicBoolean
 * <p/>
 * 1) long valueOffset(value的内存偏移)
 * 2) volatile int value(1为true, 0为false)
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicBoolean
 * @see AtomicBoolean#value
 * @see AtomicBoolean#valueOffset
 * @see AtomicBoolean#compareAndSet(boolean, boolean)
 */
public class AtomicBooleanTest {

    @Test
    public void test() {
        AtomicBoolean bool = new AtomicBoolean(true);
        Assert.assertTrue(bool.get());
        bool.set(false);
        Assert.assertFalse(bool.get());
        Assert.assertTrue(bool.compareAndSet(false, true));
        Assert.assertTrue(bool.get());
    }

}
