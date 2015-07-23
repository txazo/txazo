package org.txazo.java.pattern.behavior.visitor.core;

/**
 * ParkDestination
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class ParkDestination implements Destination {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void play() {
        System.out.println("游船赏花");
    }

}
