package org.txazo.java.pattern.behavior.visitor.core;

/**
 * MovieDestination
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class MovieDestination implements Destination {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void seeMovie() {
        System.out.println("看电影");
    }

}
