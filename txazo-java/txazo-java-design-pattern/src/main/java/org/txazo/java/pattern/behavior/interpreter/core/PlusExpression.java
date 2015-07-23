package org.txazo.java.pattern.behavior.interpreter.core;

/**
 * PlusExpression
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class PlusExpression extends DoubleExpression {

    public PlusExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double interpreter() {
        return left.interpreter() + right.interpreter();
    }

}
