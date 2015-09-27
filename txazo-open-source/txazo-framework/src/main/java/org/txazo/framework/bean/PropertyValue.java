package org.txazo.framework.bean;

/**
 * PropertyValue
 *
 * @author xiaozhou.tu
 * @since 2015-09-26
 */
public class PropertyValue {

    // Property Name
    private final String propertyName;

    // Property Value
    private final String propertyValue;

    // Property Class
    private final Class<?> propertyClass;

    // PropertyValueType
    private final PropertyValueType setterValueType;

    public PropertyValue(String propertyName, String propertyValue, PropertyValueType setterValueType) {
        this(propertyName, propertyValue, null, setterValueType);
    }

    public PropertyValue(String propertyName, Class<?> propertyClass, PropertyValueType setterValueType) {
        this(propertyName, null, propertyClass, setterValueType);
    }

    public PropertyValue(String propertyName, String propertyValue, Class<?> propertyClass, PropertyValueType setterValueType) {
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
        this.propertyClass = propertyClass;
        this.setterValueType = setterValueType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public Class<?> getPropertyClass() {
        return propertyClass;
    }

    public PropertyValueType getSetterValueType() {
        return setterValueType;
    }

}
