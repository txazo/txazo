package org.txazo.java.pattern.creational.factorymethod.core;

/**
 * BMCarFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class BCCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new BCCar();
    }

}
