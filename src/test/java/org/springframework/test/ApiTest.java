package org.springframework.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.bean.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1.创建BeanFactory工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 2.包装BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        // 3.注册BeanDefinition
        defaultListableBeanFactory.registerBeanDefinition(UserService.class.getSimpleName(), beanDefinition);

        // 4.获取Bean对象
        UserService userServiceBean = (UserService) defaultListableBeanFactory.getBean(UserService.class.getSimpleName(), "wcs");
        userServiceBean.queryUserInfo();
    }

    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"wcs"});
        System.out.println(obj);
    }

    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("wcs");
        userService.queryUserInfo();
    }

    @Test
    public void testParameterType() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        Constructor<?> constructor = null;
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (declaredConstructor.getParameters().length == 1) {
                constructor = declaredConstructor;
                break;
            }
        }

        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("wcs");
        userService.queryUserInfo();
    }
}
