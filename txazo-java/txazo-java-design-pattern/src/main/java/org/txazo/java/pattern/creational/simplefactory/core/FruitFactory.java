package org.txazo.java.pattern.creational.simplefactory.core;

/**
 * FruitFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.07.2015
 */
public abstract class FruitFactory {

    public static Fruit createFruit(String name) {
        if ("apple".equalsIgnoreCase(name)) {
            return new Apple();
        }
        return new Orange();
    }

}
