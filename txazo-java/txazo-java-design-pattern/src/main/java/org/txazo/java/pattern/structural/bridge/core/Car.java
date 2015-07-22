package org.txazo.java.pattern.structural.bridge.core;

/**
 * Car
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public abstract class Car {

    protected Road road;

    public Car(Road road) {
        this.road = road;
    }

    public abstract void ride();

}
