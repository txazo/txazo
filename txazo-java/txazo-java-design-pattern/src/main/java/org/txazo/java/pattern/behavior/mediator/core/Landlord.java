package org.txazo.java.pattern.behavior.mediator.core;

/**
 * Landlord - 房东
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Landlord extends Customer {

    public Landlord(String name, RealEstateMediator mediator) {
        super(name, mediator);
        mediator.setLandlord(this);
    }

    public void publishRent(String description) {
        mediator.sendMessage(description, this);
    }

}
