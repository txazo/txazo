package org.txazo.java.concurrency.lock;

/**
 * VolatileTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 24.07.2015
 */
public class VolatileTest {

    /**
     * volatile
     *
     * 1. 保证可见性
     * 2. 不保证原子性
     * 3. 实现原理: 写操作添加内存屏障lock指令
     * 4. 锁释放与volatile写有相同的内存语义
     * 5. 锁获取与volatile读有相同的内存语义
     * 6. CAS同时具有volatile读和volatile写的内存语义
     */

}
