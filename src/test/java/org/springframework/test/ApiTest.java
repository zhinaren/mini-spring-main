package org.springframework.test;

import org.junit.Test;
import org.springframework.BeanDefinition;
import org.springframework.BeanFactory;
import org.springframework.test.bean.UserService;

public class ApiTest {

    @Test
    public void testBeanFactory() {

        // 1.包装成BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        // 2.注册BeanDefinition
        BeanFactory.registerBeanDefinition(UserService.class.getSimpleName(), beanDefinition);

        // 3.获取Bean
        UserService userService = (UserService) BeanFactory.getBean(UserService.class.getSimpleName());
        userService.queryUserInfo();
    }
}
