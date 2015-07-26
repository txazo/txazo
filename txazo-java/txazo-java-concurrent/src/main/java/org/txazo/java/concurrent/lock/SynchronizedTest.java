package org.txazo.java.concurrent.lock;

/**
 * SynchronizedTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 24.07.2015
 */
public class SynchronizedTest {

    /**
     * synchronized
     * <p/>
     * 锁
     * 1) 偏向锁
     * 2) 轻量级锁
     * 3) 重量级锁
     */

    private static Object lock = new Object();

    /**
     * synchronized同步方法(this)
     */
    public synchronized void synchronizedMethod() {
    }

    /**
     * synchronized静态同步方法(SynchronizedTest.class)
     */
    public static synchronized void synchronizedStaticMethod() {
    }

    /**
     * synchronized同步代码块(lock)
     */
    public void synchronizedBlock() {
        synchronized (lock) {
        }
    }

}
