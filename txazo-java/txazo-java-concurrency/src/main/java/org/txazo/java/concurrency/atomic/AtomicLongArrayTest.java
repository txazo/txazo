package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * 原子操作类－AtomicLongArray
 * <p/>
 * 1) final int base
 * 2) final int shift
 * 3) final long[] array
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicLongArray
 * @see AtomicLongArray#base
 * @see AtomicLongArray#shift
 * @see AtomicLongArray#array
 */
public class AtomicLongArrayTest {

    @Test
    public void test() {
        AtomicLongArray array = new AtomicLongArray(1);
        array.set(0, 1);
        Assert.assertEquals(1, array.get(0));
        Assert.assertTrue(array.compareAndSet(0, 1, 10));
        Assert.assertEquals(10, array.get(0));
    }

}
