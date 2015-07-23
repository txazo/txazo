package org.txazo.java.pattern.behavior.strategy.core;

/**
 * Context
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Context {

    private Strategy strategy;

    public int calculate(int a, int b) {
        return strategy.calculate(a, b);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}
