package com.fanfte.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by tianen on 2018/11/22
 *
 * @author fanfte
 * @date 2018/11/22
 **/
public class UserAware implements ApplicationContextAware, BeanFactoryAware, BeanNameAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory called");
        System.out.println(beanFactory.isSingleton("user"));
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName called");
        System.out.println("bean name " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext called");
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }
}
