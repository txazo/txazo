package org.txazo.framework.bean.factory;

import org.txazo.framework.bean.Bean;
import org.txazo.framework.bean.BeanException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    protected final Map<String, Bean> beanMap = new ConcurrentHashMap<String, Bean>(64);
    protected final Map<Class<?>, String[]> beanNamesByType = new ConcurrentHashMap<Class<?>, String[]>(64);

    @Override
    public Object getBean(String name) throws BeanException {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        Object bean = getBean(name);
        if (requiredType != null && !requiredType.isAssignableFrom(bean.getClass())) {
            throw new BeanException();
        }
        return (T) bean;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeanException {
        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public Class<?> getType(String name) throws BeanException {
        return null;
    }

}
