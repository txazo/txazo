package org.txazo.java.pattern.behavior.mediator.core;

/**
 * Tenant - 租客
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Tenant extends Customer {

    public Tenant(String name, RealEstateMediator mediator) {
        super(name, mediator);
        mediator.setTenant(this);
    }

    public void intendRent(String description) {
        mediator.sendMessage(description, this);
    }

}
