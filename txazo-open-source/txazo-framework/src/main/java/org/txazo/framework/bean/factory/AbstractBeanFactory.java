package org.txazo.framework.bean.factory;

import org.txazo.framework.bean.AbstractBeanInjector;
import org.txazo.framework.bean.factory.config.Bean;
import org.txazo.framework.bean.BeanException;
import org.txazo.framework.util.ArrayUtils;
import org.txazo.framework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AbstractBeanFactory
 *
 * @author xiaozhou.tu
 * @since 2015-09-27
 */
public abstract class AbstractBeanFactory extends AbstractBeanInjector implements BeanFactory {

    protected final Map<String, Bean> beans = new ConcurrentHashMap<String, Bean>(64);

    protected final Map<Class<?>, String[]> beanNamesByType = new ConcurrentHashMap<Class<?>, String[]>(64);

    private final ReentrantLock beanNamesByTypeLock = new ReentrantLock();

    @Override
    public final Object getBean(String name) {
        Bean bean = getBeanByName(name);
        return bean != null ? bean.getValue() : null;
    }

    private Bean getBeanByName(String name) {
        return beans.get(name);
    }

    @Override
    public final <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        Object beanValue = getBean(name);
        if (beanValue != null && requiredType != null && !requiredType.isAssignableFrom(beanValue.getClass())) {
            throw new BeanException("Bean with name '" + name + "' is type of " + beanValue.getClass().getName() + " but not " + requiredType.getName());
        }
        return (T) beanValue;
    }

    @Override
    public final <T> T getBean(Class<T> requiredType) throws BeanException {
        Assert.notNull(requiredType, "RequiredType must not be null");

        String[] beanNames = getNames(requiredType);
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
        return beans.containsKey(name);
    }

    @Override
    public final boolean containsBean(Class<?> requiredType) {
        return ArrayUtils.isNotEmpty(getNames(requiredType));
    }

    @Override
    public final boolean isTypeMatch(String name, Class<?> targetType) throws BeanException {
        Assert.notEmpty(name, "Name must not be empty");
        Assert.notNull(targetType, "TargetType must not be null");

        Class<?> type = getType(name);
        if (type == null) {
            throw new BeanException("Bean name with '" + name + "' not exists");
        }

        return targetType.isAssignableFrom(type);
    }

    @Override
    public final Class<?> getType(String name) {
        Bean bean = getBeanByName(name);
        return bean != null ? bean.getBeanClass() : null;
    }

    @Override
    public final String[] getNames(Class<?> requiredType) {
        String[] beanNames = beanNamesByType.get(requiredType);
        return beanNames != null ? beanNames : getNamesFromBean(requiredType);
    }

    private String[] getNamesFromBean(Class<?> requiredType) {
        String[] beanNames = null;
        beanNamesByTypeLock.lock();
        try {
            List<String> beanNameList = new ArrayList<String>();
            for (Bean bean : beans.values()) {
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
