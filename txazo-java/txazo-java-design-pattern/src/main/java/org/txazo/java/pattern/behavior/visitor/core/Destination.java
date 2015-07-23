package org.txazo.java.pattern.behavior.visitor.core;

/**
 * Destination
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public interface Destination {

    public void accept(Visitor visitor);

}
