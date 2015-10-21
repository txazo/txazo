package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子操作类－AtomicReference
 * <p/>
 * 1) long valueOffset(value的内存偏移)
 * 2) volatile V value
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicReference
 * @see AtomicReference#value
 * @see AtomicReference#valueOffset
 * @see AtomicReference#compareAndSet(Object, Object)
 */
public class AtomicReferenceTest {

    @Test
    public void test() {
        AtomicReference<String> reference = new AtomicReference<String>();
        Assert.assertNull(reference.get());
        reference.set("root");
        Assert.assertEquals("root", reference.get());
        Assert.assertTrue(reference.compareAndSet("root", "admin"));
        Assert.assertEquals("admin", reference.get());
    }

}
