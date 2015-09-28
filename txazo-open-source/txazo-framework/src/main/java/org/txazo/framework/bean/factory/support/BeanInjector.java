package org.txazo.framework.bean.factory.support;

import org.txazo.framework.bean.BeanException;
import org.txazo.framework.bean.factory.BeanFactory;
import org.txazo.framework.bean.factory.config.Bean;

public interface BeanInjector extends BeanFactory {

    void injectBean(Bean bean) throws BeanException;

}
