package org.txazo.java.pattern.creational.singleton.core;

/**
 * HungrySingleton - 饿汉式单例
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
