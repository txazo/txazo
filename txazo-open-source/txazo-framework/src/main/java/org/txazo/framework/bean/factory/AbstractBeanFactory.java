package org.txazo.framework.bean.factory;

import org.txazo.framework.bean.Bean;
import org.txazo.framework.bean.BeanException;
import org.txazo.framework.util.ArrayUtils;
import org.txazo.framework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractBeanFactory implements BeanFactory {

    private final ReentrantLock beanNamesByTypeLock = new ReentrantLock();

    protected final Map<String, Bean> beanMap = new ConcurrentHashMap<String, Bean>(64);
    protected final Map<Class<?>, String[]> beanNamesByType = new ConcurrentHashMap<Class<?>, String[]>(64);

    @Override
    public final Object getBean(String name) {
        Bean bean = getBeanByName(name);
        return bean != null ? bean.getValue() : null;
    }

    private Bean getBeanByName(String name) {
        return beanMap.get(name);
    }

    @Override
    public final <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        Object bean = getBean(name);
        if (bean != null && requiredType != null && !requiredType.isAssignableFrom(bean.getClass())) {
            throw new BeanException("Bean with name '" + name + "' is type of " + bean.getClass().getName() + " but not " + requiredType.getName());
        }
        return (T) bean;
    }

    @Override
    public final <T> T getBean(Class<T> requiredType) throws BeanException {
        Assert.notNull(requiredType, "RequiredType must not be null");

        String[] beanNames = getName(requiredType);
        if (ArrayUtils.isNotEmpty(beanNames)) {
            if (beanNames.length == 1) {
                return (T) getBean(beanNames[0]);
            }
            throw new BeanException("Bean with type " + requiredType.getName() + " has one more instance");
        }

        return null;
    }

    @Override
    public final boolean containsBean(String name) {
        return beanMap.containsKey(name);
    }

    @Override
    public final boolean containsBean(Class<?> requiredType) {
        return ArrayUtils.isNotEmpty(getName(requiredType));
    }

    @Override
    public final Class<?> getType(String name) {
        Bean bean = getBeanByName(name);
        return bean != null ? bean.getBeanClass() : null;
    }

    @Override
    public final String[] getName(Class<?> requiredType) {
        String[] beanNames = beanNamesByType.get(requiredType);
        return beanNames != null ? beanNames : getNameFromBean(requiredType);
    }

    private String[] getNameFromBean(Class<?> requiredType) {
        String[] beanNames = null;
        beanNamesByTypeLock.lock();
        try {
            List<String> beanNameList = new ArrayList<String>();
            for (Bean bean : beanMap.values()) {
                if (requiredType.isAssignableFrom(bean.getBeanClass())) {
                    beanNameList.add(bean.getBeanName());
                }
            }
            beanNames = beanNameList.toArray(new String[0]);
            beanNamesByType.put(requiredType, beanNames);
        } finally {
            beanNamesByTypeLock.unlock();
        }
        return beanNames;
    }

}
