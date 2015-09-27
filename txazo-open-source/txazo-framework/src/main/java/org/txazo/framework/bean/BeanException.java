package org.txazo.framework.bean;

/**
 * BeanException
 *
 * @author xiaozhou.tu
 * @since 2015-09-27
 */
public class BeanException extends RuntimeException {

    public BeanException() {
        super();
    }

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }

}
