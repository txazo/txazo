package org.txazo.framework.bean.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.txazo.framework.bean.factory.config.Bean;
import org.txazo.framework.bean.BeanException;
import org.txazo.framework.bean.factory.support.BeanRegistry;
import org.txazo.framework.bean.BeanUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * RegistryBeanFactory
 *
 * @author xiaozhou.tu
 * @since 2015-09-27
 */
public class RegistryBeanFactory extends AbstractBeanFactory implements BeanRegistry {

    private static final Logger logger = LoggerFactory.getLogger(RegistryBeanFactory.class);

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void registerBean(Bean bean) throws BeanException {
        BeanUtils.checkBean(bean);

        lock.lock();
        try {
            if (containsBean(bean.getBeanName())) {
                throw new BeanException("Bean with name '" + bean.getBeanName() + "' already exists");
            }

            beans.put(bean.getBeanName(), bean);

            logger.debug("Register Bean: " + bean);
        } finally {
            lock.unlock();
        }
    }

}
