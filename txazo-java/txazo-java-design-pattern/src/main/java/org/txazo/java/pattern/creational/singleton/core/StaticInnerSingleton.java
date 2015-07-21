package org.txazo.java.pattern.creational.singleton.core;

/**
 * StaticInnerSingleton - 静态内部类单例
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton() {
    }

    public static StaticInnerSingleton getInstance() {
        return StaticInnerSingletonHolder.instance;
    }

    private static class StaticInnerSingletonHolder {

        private static StaticInnerSingleton instance = new StaticInnerSingleton();

    }

}
