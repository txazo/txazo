package org.txazo.java.pattern.creational.singleton.core;

/**
 * StaticInnerClassSingleton - 静态内部类单例
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClassSingletonHolder.instance;
    }

    private static class StaticInnerClassSingletonHolder {

        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();

    }

}
