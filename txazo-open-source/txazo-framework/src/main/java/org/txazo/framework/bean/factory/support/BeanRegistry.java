package org.txazo.framework.bean.factory.support;

import org.txazo.framework.bean.factory.config.Bean;
import org.txazo.framework.bean.BeanException;

/**
 * BeanRegistry
 *
 * @author xiaozhou.tu
 * @since 2015-09-27
 */
public interface BeanRegistry {

    void registerBean(Bean bean) throws BeanException;

}
