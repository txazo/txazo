package org.txazo.java.pattern.behavior.chain.core;

/**
 * LessHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class LessHandler extends AbstractHandler {

    @Override
    public void handle(int quantity) {
        if (quantity <= 100) {
            System.out.println("less handler with quantity " + quantity);
        } else if (next != null) {
            next.handle(quantity);
        }
    }

}
