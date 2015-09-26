package org.txazo.framework.bean.factory;

import org.txazo.framework.bean.Bean;
import org.txazo.framework.bean.BeanException;
import org.txazo.framework.util.Assert;
import org.txazo.framework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    protected final Map<String, Bean> beanMap = new ConcurrentHashMap<String, Bean>(64);
    protected final Map<Class<?>, List<Object>> cacheMap = new ConcurrentHashMap<Class<?>, List<Object>>(64);

    @Override
    public Object getBean(String name) throws BeanException {
        Bean bean = beanMap.get(name);
        if (bean != null) {
            return bean.getValue();
        }
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        Object bean = getBean(name);
        if (requiredType != null && !requiredType.isAssignableFrom(bean.getClass())) {
            throw new BeanException(requiredType.getClass().getName() + "");
        }
        return (T) bean;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeanException {
        Assert.notNull(requiredType, "RequiredType must not be null");

        List<Object> objects = cacheMap.get(requiredType);
        if (CollectionUtils.isNotEmpty(objects)) {
            if (objects.size() == 1) {
                Object bean = objects.get(0);
                if (!requiredType.isAssignableFrom(bean.getClass())) {
                    throw new BeanException(requiredType.getClass().getName() + "");
                }
                return (T) bean;
            }
            throw new BeanException("");
        }

        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return beanMap.containsKey(name);
    }

    @Override
    public Class<?> getType(String name) throws BeanException {
        Bean bean = beanMap.get(name);
        if (bean != null) {
            return bean.getBeanClass();
        }
        return null;
    }

}
