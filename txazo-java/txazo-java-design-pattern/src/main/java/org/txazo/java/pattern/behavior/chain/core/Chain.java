package org.txazo.java.pattern.behavior.chain.core;

/**
 * Chain
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Chain {

    private Handler chain;

    public void addHandler(AbstractHandler handler) {
        handler.setNext(chain);
        chain = handler;
    }

    public void doHandle(int quantity) {
        chain.handle(quantity);
    }

}
