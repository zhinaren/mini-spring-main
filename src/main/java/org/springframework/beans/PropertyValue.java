package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }public class PropertyValues {

        private final List<PropertyValue> propertyValueList = new ArrayList<>();

        public void addPropertyValue(PropertyValue pv) {
            this.propertyValueList.add(pv);
        }

        public PropertyValue[] getPropertyValues() {
            return this.propertyValueList.toArray(new PropertyValue[0]);
        }

        public PropertyValue getPropertyValue(String propertyName) {
            for (PropertyValue pv : this.propertyValueList) {
                if (pv.getName().equals(propertyName)) {
                    return pv;
                }
            }
            return null;
        }

    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}