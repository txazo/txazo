package org.txazo.framework.bean.factory;

import org.txazo.framework.bean.BeanException;

public interface BeanFactory {

    Object getBean(String name);

    <T> T getBean(String name, Class<T> requiredType) throws BeanException;

    <T> T getBean(Class<T> requiredType) throws BeanException;

    boolean containsBean(String name);

    boolean containsBean(Class<?> requiredType);

    Class<?> getType(String name);

    String[] getName(Class<?> requiredType);
}
