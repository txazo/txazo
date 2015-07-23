package org.txazo.java.pattern.behavior.observer.core;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteSubject
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class ConcreteSubject implements Subject {

    private String state;
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public synchronized void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public synchronized void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    @Override
    public void change(String state) {
        this.state = state;
        notifyObservers();
    }

}
