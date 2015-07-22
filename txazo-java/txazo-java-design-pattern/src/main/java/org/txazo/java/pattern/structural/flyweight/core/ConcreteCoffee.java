package org.txazo.java.pattern.structural.flyweight.core;

/**
 * ConcreteCoffee
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class ConcreteCoffee implements Coffee {

    private String flavor;

    public ConcreteCoffee(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public void drink(String name) {
        System.out.println(name + " drink " + flavor + " coffee");
    }

}
