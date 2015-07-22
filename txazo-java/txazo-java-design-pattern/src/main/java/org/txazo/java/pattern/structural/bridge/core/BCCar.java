package org.txazo.java.pattern.structural.bridge.core;

/**
 * BCCar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class BCCar extends Car {

    public BCCar(Road road) {
        super(road);
    }

    @Override
    public void ride() {
        System.out.println("奔驰 ride on " + road.getName());
    }

}
