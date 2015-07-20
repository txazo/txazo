package org.txazo.java.pattern.creational.simplefactory.core;

import org.junit.Test;

/**
 * FruitFactoryTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.07.2015
 */
public class FruitFactoryTest {

    @Test
    public void test() {
        Fruit fruit = FruitFactory.createFruit("apple");
        fruit.eat();
    }

}
