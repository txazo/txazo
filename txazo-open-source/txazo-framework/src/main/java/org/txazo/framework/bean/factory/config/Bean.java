package org.txazo.framework.bean.factory.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean
 *
 * @author xiaozhou.tu
 * @since 2015-09-26
 */
public class Bean extends Value {

    // Bean Name
    private String beanName;

    // Bean Class
    private Class<?> beanClass;

    // Bean Source
    private BeanSource beanSource;

    // Bean PropertyValue List
    private List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    public Bean() {
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanSource getBeanSource() {
        return beanSource;
    }

    public void setBeanSource(BeanSource beanSource) {
        this.beanSource = beanSource;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    @Override
    public String toString() {
        return "[" + beanName + ", " + beanClass.getName() + ", " + beanSource + "]";
    }

}
