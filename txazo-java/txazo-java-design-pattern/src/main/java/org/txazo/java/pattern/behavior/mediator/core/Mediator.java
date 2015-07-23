package org.txazo.java.pattern.behavior.mediator.core;

/**
 * Mediator
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public interface Mediator {

    public void sendMessage(String message, Customer customer);

}
