package org.txazo.java.pattern.behavior.interpreter.core;

/**
 * ValueExpression
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class ValueExpression implements Expression {

    private double value;

    public ValueExpression(double value) {
        this.value = value;
    }

    @Override
    public double interpreter() {
        return value;
    }

}
