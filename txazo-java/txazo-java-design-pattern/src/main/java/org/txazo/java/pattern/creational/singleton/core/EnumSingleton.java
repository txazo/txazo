package org.txazo.java.pattern.creational.singleton.core;

/**
 * EnumSingleton - 枚举单例
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public enum EnumSingleton {

    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
