package org.txazo.java.pattern.behavior.interpreter.core;

/**
 * 非终结符表达式
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
