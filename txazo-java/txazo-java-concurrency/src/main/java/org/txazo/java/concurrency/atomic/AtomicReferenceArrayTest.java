package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 原子操作类－AtomicReferenceArray
 * <p/>
 * 1) final int base
 * 2) final int shift
 * 3) final Object[] array
 *
 * @author xiaozhou.tu
 * @date 2015-10-21
 * @see AtomicReferenceArray
 * @see AtomicReferenceArray#base
 * @see AtomicReferenceArray#shift
 * @see AtomicReferenceArray#array
 * @see AtomicReferenceArray#compareAndSet(int, Object, Object)
 */
public class AtomicReferenceArrayTest {

    @Test
    public void test() {
        AtomicReferenceArray array = new AtomicReferenceArray(1);
        array.set(0, "root");
        Assert.assertEquals("root", array.get(0));
        Assert.assertTrue(array.compareAndSet(0, "root", "admin"));
        Assert.assertEquals("admin", array.get(0));
    }

}
