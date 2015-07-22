package org.txazo.java.pattern.structural.bridge.core;

/**
 * BMCar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class BMCar extends Car {

    public BMCar(Road road) {
        super(road);
    }

    @Override
    public void ride() {
        System.out.println("宝马 ride on " + road.getName());
    }

}
