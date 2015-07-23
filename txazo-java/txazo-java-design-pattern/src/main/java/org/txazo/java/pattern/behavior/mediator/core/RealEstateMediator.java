package org.txazo.java.pattern.behavior.mediator.core;

/**
 * RealEstateMediator - 房产中介
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class RealEstateMediator implements Mediator {

    private Tenant tenant;
    private Landlord landlord;

    @Override
    public void sendMessage(String message, Customer customer) {
        if (customer == tenant) {
            landlord.receiveMessage(message, customer.getName());
        } else if (customer == landlord) {
            tenant.receiveMessage(message, customer.getName());
        }
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

}
