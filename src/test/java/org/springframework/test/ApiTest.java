package org.springframework.test;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.bean.UserService;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1.创建BeanFactory工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.包装BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        // 3.注册BeanDefinition
        beanFactory.registerBeanDefinition(UserService.class.getSimpleName(), beanDefinition);

        // 4.获取Bean
        UserService userServiceBean = (UserService) beanFactory.getBean(UserService.class.getSimpleName());

        // 5.查询用户信息
        userServiceBean.queryUserInfo();

        UserService userServiceBean2 = (UserService) beanFactory.getBean(UserService.class.getSimpleName());
        System.out.println(userServiceBean == userServiceBean2);
    }
}
