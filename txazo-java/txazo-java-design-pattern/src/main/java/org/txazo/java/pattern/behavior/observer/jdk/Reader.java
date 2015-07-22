package org.txazo.java.pattern.behavior.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Reader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Reader implements Observer {

    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " receive newspaper publish notify: " + arg);
    }

}
