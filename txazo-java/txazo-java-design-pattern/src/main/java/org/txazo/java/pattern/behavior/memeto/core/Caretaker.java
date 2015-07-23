package org.txazo.java.pattern.behavior.memeto.core;

/**
 * Caretaker
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

}
