package org.txazo.framework.bean;

/**
 * BeanRegister
 *
 * @author xiaozhou.tu
 * @since 2015-09-27
 */
public interface BeanRegister {

    void registerBean(Bean bean) throws BeanException;

}
