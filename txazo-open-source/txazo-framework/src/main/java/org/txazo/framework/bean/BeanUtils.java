package org.txazo.framework.bean;

import org.txazo.framework.util.Assert;

public abstract class BeanUtils {

    public static void checkBean(Bean bean) {
        Assert.notNull(bean, "Bean must not be null");
        Assert.notEmpty(bean.getBeanName(), "Bean name must not be empty");
        Assert.notNull(bean.getBeanClass(), "Bean class must not be null");
        Assert.notNull(bean.getBeanSource(), "Bean source must not be null");
    }

}
