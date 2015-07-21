package org.txazo.java.pattern.creational.simplefactory.core;

import org.junit.Test;

/**
 * SimpleFactoryTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.07.2015
 */
public class SimpleFactoryTest {

    @Test
    public void test() {
        Fruit fruit = FruitFactory.createFruit("apple");
        fruit.eat();

        fruit = FruitFactory.createFruit("orange");
        fruit.eat();
    }

}
