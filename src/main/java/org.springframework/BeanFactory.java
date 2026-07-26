package org.springframework;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private static final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public static Object getBean(String name) {
        return beanDefinitionMap.get(name);
    }

    public static void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
