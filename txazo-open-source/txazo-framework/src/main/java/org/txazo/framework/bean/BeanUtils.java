package org.txazo.framework.bean;

import org.txazo.framework.bean.factory.config.Bean;
import org.txazo.framework.bean.factory.config.PropertyValue;
import org.txazo.framework.util.Assert;
import org.txazo.framework.util.CollectionUtils;
import org.txazo.framework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * BeanUtils
 *
 * @author xiaozhou.tu
 * @since 2015-09-27
 */
public abstract class BeanUtils {

    public static void checkBean(Bean bean) {
        Assert.notNull(bean, "Bean must not be null");
        Assert.notEmpty(bean.getBeanName(), "Bean name must not be empty");
        Assert.notNull(bean.getBeanClass(), "Bean class must not be null");
        Assert.notNull(bean.getBeanSource(), "Bean source must not be null");

        List<PropertyValue> propertyValues = bean.getPropertyValues();
        if (CollectionUtils.isNotEmpty(propertyValues)) {
            for (PropertyValue propertyValue : propertyValues) {
                propertyValue.validate();
            }
        }
    }

    public static <T> T instantiateClass(Class<T> clazz) throws BeanException {
        Assert.notNull(clazz, "Class must not be null");
        if (clazz.isInterface()) {
            throw new BeanInstantiationException(clazz, "Specified class is an interface");
        }
        try {
            return instantiateClass(clazz.getDeclaredConstructor());
        } catch (NoSuchMethodException ex) {
            throw new BeanInstantiationException(clazz, "No default constructor found", ex);
        }
    }

    public static <T> T instantiateClass(Constructor<T> constructor, Object... args) throws BeanException {
        Assert.notNull(constructor, "Constructor must not be null");
        try {
            ReflectionUtils.makeAccessible(constructor);
            return constructor.newInstance(args);
        } catch (InstantiationException ex) {
            throw new BeanInstantiationException(constructor.getDeclaringClass(),
                    "Is it an abstract class?", ex);
        } catch (IllegalAccessException ex) {
            throw new BeanInstantiationException(constructor.getDeclaringClass(),
                    "Is the constructor accessible?", ex);
        } catch (IllegalArgumentException ex) {
            throw new BeanInstantiationException(constructor.getDeclaringClass(),
                    "Illegal arguments for constructor", ex);
        } catch (InvocationTargetException ex) {
            throw new BeanInstantiationException(constructor.getDeclaringClass(),
                    "Constructor threw exception", ex.getTargetException());
        }
    }

}
