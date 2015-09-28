package org.txazo.framework.bean.factory;

import org.txazo.framework.bean.BeanException;

/**
 * BeanFactory
 *
 * @author xiaozhou.tu
 * @since 2015-09-27
 */
public interface BeanFactory {

    Object getBean(String name);

    <T> T getBean(String name, Class<T> requiredType) throws BeanException;

    <T> T getBean(Class<T> requiredType) throws BeanException;

    boolean containsBean(String name);

    boolean containsBean(Class<?> requiredType);

    boolean isTypeMatch(String name, Class<?> targetType) throws BeanException;

    Class<?> getType(String name);

    String[] getNames(Class<?> requiredType);

}
