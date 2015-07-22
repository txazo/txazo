package org.txazo.java.pattern.structural.flyweight.core;

import java.util.HashMap;
import java.util.Map;

/**
 * CoffeeFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class CoffeeFactory {

    private Map<String, Coffee> coffeeMap = new HashMap<String, Coffee>();

    private CoffeeFactory() {
    }

    public Coffee getCoffee(String key) {
        Coffee coffee = coffeeMap.get(key);
        if (coffee == null) {
            /** 此处允许多次并发执行 */
            coffee = new ConcreteCoffee(key);
            coffeeMap.put(key, coffee);
        }
        return coffee;
    }

    public static CoffeeFactory getInstance() {
        return CoffeeFactoryHolder.instance;
    }

    private static class CoffeeFactoryHolder {

        private static final CoffeeFactory instance = new CoffeeFactory();

    }

}
