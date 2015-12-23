package org.txazo.java.pattern.structural.flyweight.core;

import org.junit.Test;

/**
 * 享元模式
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class FlyweightTest {

    @Test
    public void test() {
        CoffeeFactory factory = CoffeeFactory.getInstance();
        factory.getCoffee("摩卡").drink("A");
        factory.getCoffee("巧克力").drink("B");
        factory.getCoffee("巧克力").drink("C");
        factory.getCoffee("卡布奇诺").drink("D");
        factory.getCoffee("卡布奇诺").drink("E");
        factory.getCoffee("卡布奇诺").drink("F");
    }

}
