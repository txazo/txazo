package org.txazo.framework.bean.factory.support;

import org.txazo.framework.bean.factory.config.Bean;
import org.txazo.framework.bean.factory.config.BeanSource;
import org.txazo.framework.util.ClassUtils;

public class BeanBuilder {

    private Bean bean;

    private BeanBuilder() {
    }

    public Bean getBean() {
        return this.bean;
    }

    public void setBeanName(String beanName) {
        this.bean.setBeanName(beanName);
    }

    public void setBeanClass(Class<?> beanClass) {
        this.bean.setBeanClass(beanClass);
    }

    public void setBeanClassName(String beanClassName) throws ClassNotFoundException {
        this.bean.setBeanClass(ClassUtils.getClass(beanClassName));
    }

    public void setBeanSource(BeanSource beanSource) {
        this.bean.setBeanSource(beanSource);
    }

    public static BeanBuilder genericBean() {
        return genericBean(null, (Class<?>) null, null);
    }

    public static BeanBuilder genericBean(String beanName) {
        return genericBean(beanName, (Class<?>) null, null);
    }

    public static BeanBuilder genericBean(String beanName, Class<?> beanClass) {
        return genericBean(beanName, beanClass, null);
    }

    public static BeanBuilder genericBean(String beanName, String beanClassName) throws ClassNotFoundException {
        return genericBean(beanName, ClassUtils.getClass(beanClassName), null);
    }

    public static BeanBuilder genericBean(String beanName, String beanClassName, BeanSource beanSource) throws ClassNotFoundException {
        return genericBean(beanName, ClassUtils.getClass(beanClassName), beanSource);
    }

    public static BeanBuilder genericBean(String beanName, Class<?> beanClass, BeanSource beanSource) {
        BeanBuilder builder = new BeanBuilder();
        builder.bean = new Bean();
        builder.bean.setBeanName(beanName);
        builder.bean.setBeanClass(beanClass);
        builder.bean.setBeanSource(beanSource);
        return builder;
    }

}
