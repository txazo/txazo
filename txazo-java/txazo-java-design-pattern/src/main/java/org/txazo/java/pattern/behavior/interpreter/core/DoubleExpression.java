package org.txazo.java.pattern.behavior.interpreter.core;

/**
 * 非终结符表达式
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public abstract class DoubleExpression implements Expression {

    protected Expression left;
    protected Expression right;

    public DoubleExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

}
