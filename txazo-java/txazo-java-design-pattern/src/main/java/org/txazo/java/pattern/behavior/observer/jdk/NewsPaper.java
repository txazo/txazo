package org.txazo.java.pattern.behavior.observer.jdk;

import java.util.Observable;

/**
 * NewsPaper
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class NewsPaper extends Observable {

    public void publish(String title) {
        setChanged();
        notifyObservers(title);
    }

}
