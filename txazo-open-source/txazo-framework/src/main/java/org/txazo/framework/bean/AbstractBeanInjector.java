package org.txazo.framework.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.txazo.framework.bean.factory.config.Bean;
import org.txazo.framework.bean.factory.config.PropertyValue;
import org.txazo.framework.bean.factory.support.BeanInjector;
import org.txazo.framework.util.CollectionUtils;
import org.txazo.framework.util.ReflectionUtils;

import java.lang.reflect.Field;

public abstract class AbstractBeanInjector implements BeanInjector {

    private static final Logger logger = LoggerFactory.getLogger(AbstractBeanInjector.class);

    @Override
    public void injectBean(Bean bean) throws BeanException {
        BeanUtils.checkBean(bean);

        if (bean.getValue() == null) {
            throw new BeanException(bean + "");
        }

        if (CollectionUtils.isNotEmpty(bean.getPropertyValues())) {
            for (PropertyValue propertyValue : bean.getPropertyValues()) {
                doInject(bean, propertyValue);
            }
        }
    }

    private void doInject(Bean bean, PropertyValue propertyValue) {
        Object beanPropertyValue = getPropertyValueObject(propertyValue);
        if (beanPropertyValue == null) {
            throw new BeanException(bean + " ");
        }

        Field field = ReflectionUtils.findField(bean.getBeanClass(), propertyValue.getPropertyName());
        if (field == null) {
            throw new BeanException(bean + " has no field named '" + propertyValue.getPropertyName() + "'");
        }

        ReflectionUtils.setField(field, bean.getValue(), beanPropertyValue);
    }

    private Object getPropertyValueObject(PropertyValue propertyValue) {
        switch (propertyValue.getSetterValueType()) {
            case VALUE:
                return propertyValue.getPropertyValue();
            case NAME:
                return getBean(propertyValue.getPropertyValue());
            case TYPE:
                return getBean(propertyValue.getPropertyClass());
            case NAME_AND_TYPE:
                return getBean(propertyValue.getPropertyValue(), propertyValue.getPropertyClass());
            default:
                break;
        }
        return null;
    }

}
