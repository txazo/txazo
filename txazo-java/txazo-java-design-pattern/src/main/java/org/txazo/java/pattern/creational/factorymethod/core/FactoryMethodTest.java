package org.txazo.java.pattern.creational.factorymethod.core;

import org.junit.Test;

/**
 * FactoryMethodTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class FactoryMethodTest {

    @Test
    public void test() {
        CarFactory factory = new BCCarFactory();
        Car car = factory.createCar();
        System.out.println(car.getName());

        factory = new BMCarFactory();
        car = factory.createCar();
        System.out.println(car.getName());
    }

}
