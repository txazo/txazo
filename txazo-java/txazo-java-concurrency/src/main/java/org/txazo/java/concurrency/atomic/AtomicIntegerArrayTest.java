package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子操作类－AtomicIntegerArray
 * <p/>
 * 1) final int base
 * 2) final int shift
 * 3) final int[] array
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicIntegerArray
 * @see AtomicIntegerArray#base
 * @see AtomicIntegerArray#shift
 * @see AtomicIntegerArray#array
 */
public class AtomicIntegerArrayTest {

    @Test
    public void test() {
        AtomicIntegerArray array = new AtomicIntegerArray(1);
        array.set(0, 1);
        Assert.assertEquals(1, array.get(0));
        Assert.assertTrue(array.compareAndSet(0, 1, 10));
        Assert.assertEquals(10, array.get(0));
    }

}
