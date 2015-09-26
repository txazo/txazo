package org.txazo.framework.bean.factory;

import org.txazo.framework.bean.Bean;
import org.txazo.framework.bean.BeanException;
import org.txazo.framework.bean.BeanRegister;
import org.txazo.framework.bean.BeanUtils;

import java.util.concurrent.locks.ReentrantLock;

public class DefaultBeanFactory extends AbstractBeanFactory implements BeanRegister {

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void registerBean(Bean bean) {
        BeanUtils.checkBean(bean);

        lock.lock();
        try {
            if (containsBean(bean.getBeanName())) {
                throw new BeanException("Bean with name '" + bean.getBeanName() + "' already exists");
            }

            beanMap.put(bean.getBeanName(), bean);
        } finally {
            lock.unlock();
        }
    }

}
