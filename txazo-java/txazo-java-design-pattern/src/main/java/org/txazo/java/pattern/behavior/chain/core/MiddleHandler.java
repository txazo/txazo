package org.txazo.java.pattern.behavior.chain.core;

/**
 * MiddleHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class MiddleHandler extends AbstractHandler {

    @Override
    public void handle(int quantity) {
        if (quantity > 100 && quantity < 10000) {
            System.out.println("middle handler with quantity " + quantity);
        } else if (next != null) {
            next.handle(quantity);
        }
    }

}
