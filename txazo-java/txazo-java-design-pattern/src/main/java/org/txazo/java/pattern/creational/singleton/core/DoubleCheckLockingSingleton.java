package org.txazo.java.pattern.creational.singleton.core;

/**
 * DoubleCheckLockingSingleton - 双检锁单例
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class DoubleCheckLockingSingleton {

    private static final Object lock = new Object();
    private static volatile DoubleCheckLockingSingleton instance;

    private DoubleCheckLockingSingleton() {
    }

    public static DoubleCheckLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }

}
