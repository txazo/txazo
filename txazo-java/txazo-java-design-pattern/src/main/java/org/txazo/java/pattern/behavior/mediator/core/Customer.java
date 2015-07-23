package org.txazo.java.pattern.behavior.mediator.core;

/**
 * Customer
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public abstract class Customer {

    protected String name;
    protected Mediator mediator;

    public Customer(String name, RealEstateMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void receiveMessage(String message, String from) {
        System.out.println(name + " receive message from " + from + ": " + message);
    }

    public String getName() {
        return name;
    }

}
