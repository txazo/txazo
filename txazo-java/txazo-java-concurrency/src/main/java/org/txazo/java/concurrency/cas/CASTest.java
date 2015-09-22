package org.txazo.java.concurrency.cas;

import org.junit.Test;

/**
 * CASTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 25.07.2015
 */
public class CASTest {

    /**
     * CAS - Compare And Swap
     * <pre>
     * 1) 乐观锁
     * 2) 原子操作
     * 3) 非阻塞算法
     *
     * Unsafe.compareAndSwapInt
     * 1) C实现: LOCK - 缓存锁定/总线锁定
     *      1) 缓存一致性协议, 读－写操作原子执行
     *      2) 禁止Lock前后指令重排
     *      3) 写数据刷新到主存
     *
     * CAS缺点
     * 1) ABA问题
     * 2) 循环时间长开销大, CAS自旋
     * 3) 只能保证一个共享变量的原子操作
     * </pre>
     */

    @Test
    public void testJdk7CAS() {
        final AtomicIntegerJdk7 integerJdk7 = new AtomicIntegerJdk7();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 1000.; j++) {
                        System.out.println(integerJdk7.incrementAndGet());
                    }
                }

            }).start();
        }
    }

}
