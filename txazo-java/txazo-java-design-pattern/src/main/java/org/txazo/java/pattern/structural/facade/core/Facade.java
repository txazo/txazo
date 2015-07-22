package org.txazo.java.pattern.structural.facade.core;

/**
 * Facade
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Facade {

    private Waiter waiter;
    private Cooker cooker;
    private Cashier cashier;

    public Facade() {
        waiter = new Waiter();
        cooker = new Cooker();
        cashier = new Cashier();
    }

    public void order() {
        waiter.order();
    }

    public void facade() {
        waiter.order();
        waiter.submitOrder();
        cooker.cook();
        waiter.service();
        cashier.cash();
    }

}
