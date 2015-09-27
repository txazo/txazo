package org.txazo.framework.bean;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.ReflectionUtils;

import java.lang.reflect.Field;

public abstract class AbstractBeanInjector implements BeanInjector {

    @Override
    public void injectBean(Bean bean, PropertyValue propertyValue) {
        Assert.notNull(bean, "Bean must not be null");
        Assert.notNull(propertyValue, "PropertyValue must not be null");

        Object b = bean.getValue();
        Object value = getPropertyValueObject(propertyValue);
        if (value == null) {

        }

        Field field = ReflectionUtils.findField(b.getClass(), propertyValue.getPropertyName());
        ReflectionUtils.setField(field, b, value);
    }

    private Object getPropertyValueObject(PropertyValue propertyValue) {
        switch (propertyValue.getSetterValueType()) {
            case XML_STRING:
                return propertyValue.getPropertyValue();
            case XML_REF:
                return getBean(propertyValue.getPropertyValue());
            case ANNO_TYPE:
                return getBean(propertyValue.getPropertyClass());
            case ANNO_TYPE_AND_NAME:
                return getBean(propertyValue.getPropertyValue(), propertyValue.getPropertyClass());
            case ANNO_NAME:
                return getBean(propertyValue.getPropertyValue());
            default:
                break;
        }
        return null;
    }

}
