package org.txazo.java.pattern.behavior.observer.core;

/**
 * ConcreteObserver
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Object object) {
        System.out.println(name + " receive update data: " + object);
    }

}
