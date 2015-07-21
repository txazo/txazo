package org.txazo.java.pattern.creational.singleton.core;

/**
 * LazySingleton - 懒汉式单例
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
