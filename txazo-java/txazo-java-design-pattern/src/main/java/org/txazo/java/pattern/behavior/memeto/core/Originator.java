package org.txazo.java.pattern.behavior.memeto.core;

/**
 * Originator
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Originator {

    private String state;

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
