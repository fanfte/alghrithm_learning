package com.fanfte.spring;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianen on 2018/9/27
 *
 * @author fanfte
 * @date 2018/9/27
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-test.xml");
        Car o1 = context.getBean("carFactoryBean", Car.class);
        Object o2 = context.getBean("&carFactoryBean");
        System.out.println(o1.getClass() + " " + o1.getName());
        System.out.println(o2.getClass());
    }
}
