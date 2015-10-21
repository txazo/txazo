package org.txazo.java.concurrency.thread;

import org.junit.Assert;
import org.junit.Test;

/**
 * ThreadLocalMap
 * <p/>
 * 1) Thread有实例变量ThreadLocal.ThreadLocalMap
 * 2) ThreadLocal的原理: 获取currentThread, 操作currentThread中的ThreadLocal.ThreadLocalMap
 *
 * @author xiaozhou.tu
 * @date 2015-10-09
 * @see java.lang.Thread#threadLocals
 * @see java.lang.ThreadLocal
 * @see java.lang.ThreadLocal.ThreadLocalMap
 */
public class ThreadLocalMapTest {

    private static ThreadLocal<Integer> count = new ThreadLocal<Integer>();

    @Test
    public void test() {
        count.set(1);
        Assert.assertEquals(1, (int) count.get());
    }

}
