package org.txazo.framework.bean;

public class BeanInstantiationException extends BeanException {

    private Class<?> beanClass;

    public BeanInstantiationException(Class<?> beanClass, String msg) {
        this(beanClass, msg, null);
    }

    public BeanInstantiationException(Class<?> beanClass, String msg, Throwable cause) {
        super("Could not instantiate bean class [" + beanClass.getName() + "]: " + msg, cause);
        this.beanClass = beanClass;
    }

}
