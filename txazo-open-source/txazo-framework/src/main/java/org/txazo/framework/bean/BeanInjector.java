package org.txazo.framework.bean;

import org.txazo.framework.bean.factory.BeanFactory;

public interface BeanInjector extends BeanFactory {

    void injectBean(Bean bean) throws BeanException;

}
