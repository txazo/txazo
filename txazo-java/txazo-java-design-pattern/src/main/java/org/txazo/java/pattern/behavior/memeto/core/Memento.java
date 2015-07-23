package org.txazo.java.pattern.behavior.memeto.core;

/**
 * Memento
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
