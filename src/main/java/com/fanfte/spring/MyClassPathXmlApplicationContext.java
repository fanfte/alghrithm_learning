package com.fanfte.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianen on 2018/11/2
 *
 * @author fanfte
 * @date 2018/11/2
 **/
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        super.setAllowBeanDefinitionOverriding(false);
        super.setAllowCircularReferences(false);
        super.customizeBeanFactory(beanFactory);
    }

//    @Override
//    protected void initPropertySources() {
//        getEnvironment().setRequiredProperties("VAR");
//    }
}
