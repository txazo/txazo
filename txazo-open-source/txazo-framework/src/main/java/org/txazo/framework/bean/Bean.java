package org.txazo.framework.bean;

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

    // Bean PropertySetter List
    private List<PropertySetter> propertySetters = new ArrayList<PropertySetter>();

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

    public List<PropertySetter> getPropertySetters() {
        return propertySetters;
    }

    public void setPropertySetters(List<PropertySetter> propertySetters) {
        this.propertySetters = propertySetters;
    }

}
