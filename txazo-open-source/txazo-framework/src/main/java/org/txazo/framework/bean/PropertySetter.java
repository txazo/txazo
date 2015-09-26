package org.txazo.framework.bean;

/**
 * PropertySetter
 *
 * @author xiaozhou.tu
 * @since 2015-09-26
 */
public class PropertySetter {

    // Property Name
    private String propertyName;

    // Property Value
    private String propertyValue;

    // Property Class
    private Class<?> propertyClass;

    // Property SetterValueType
    private SetterValueType setterValueType;

    public PropertySetter() {
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Class<?> getPropertyClass() {
        return propertyClass;
    }

    public void setPropertyClass(Class<?> propertyClass) {
        this.propertyClass = propertyClass;
    }

    public SetterValueType getSetterValueType() {
        return setterValueType;
    }

    public void setSetterValueType(SetterValueType setterValueType) {
        this.setterValueType = setterValueType;
    }

}
