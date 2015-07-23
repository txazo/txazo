package org.txazo.java.pattern.behavior.visitor.core;

/**
 * AdultVisitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class AdultVisitor implements Visitor {

    @Override
    public void visit(ParkDestination destination) {
        System.out.println("Adult Visit: 公园");
        destination.play();
    }

    @Override
    public void visit(MovieDestination destination) {
        System.out.println("Adult Visit: 电影院");
        destination.seeMovie();
    }

}
