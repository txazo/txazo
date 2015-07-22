package org.txazo.java.pattern.behavior.chain.core;

/**
 * AbstractHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public abstract class AbstractHandler implements Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }
}
