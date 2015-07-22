package org.txazo.java.pattern.structural.bridge.core;

import org.junit.Test;

/**
 * BridgeTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class BridgeTest {

    @Test
    public void test() {
        Car car = new BMCar(new TarRoad());
        car.ride();

        car = new BMCar(new HighwayRoad());
        car.ride();

        car = new BCCar(new TarRoad());
        car.ride();

        car = new BCCar(new HighwayRoad());
        car.ride();
    }

}
