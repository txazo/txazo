package org.txazo.java.pattern.behavior.chain.core;

/**
 * MassHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class MassHandler extends AbstractHandler {

    @Override
    public void handle(int quantity) {
        if (quantity >= 10000) {
            System.out.println("MassHandler with quantity " + quantity);
        } else if (next != null) {
            next.handle(quantity);
        }
    }

}
