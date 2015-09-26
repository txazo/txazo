package org.txazo.framework.bean;

/**
 * Value
 *
 * @author xiaozhou.tu
 * @since 2015-09-26
 */
public abstract class Value {

    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
