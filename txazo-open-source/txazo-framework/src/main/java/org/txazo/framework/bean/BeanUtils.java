package org.txazo.framework.bean;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.CollectionUtils;

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

}
