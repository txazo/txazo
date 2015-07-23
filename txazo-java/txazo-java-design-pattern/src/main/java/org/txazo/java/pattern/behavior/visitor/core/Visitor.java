package org.txazo.java.pattern.behavior.visitor.core;

/**
 * Visitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public interface Visitor {

    public void visit(ParkDestination destination);

    public void visit(MovieDestination destination);

}
