package org.txazo.java.pattern.behavior.strategy.core;

/**
 * PlusStrategy
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class PlusStrategy implements Strategy {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }

}
