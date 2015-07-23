package org.txazo.java.pattern.behavior.strategy.core;

/**
 * MulStrategy
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class MulStrategy implements Strategy {

    @Override
    public int calculate(int a, int b) {
        return a * b;
    }

}
