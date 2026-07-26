package org.springframework.beans.factory.config;

import org.springframework.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends SingletonBeanRegistry, BeanFactory {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}