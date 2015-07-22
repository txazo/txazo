package org.txazo.java.pattern.behavior.observer.core;

/**
 * Subject
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public interface Subject {

    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notifyObservers();

    public void change(String state);

}
