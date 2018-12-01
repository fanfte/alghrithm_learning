package com.fanfte.spring.listener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianen on 2018/11/22
 *
 * @author fanfte
 * @date 2018/11/22
 **/
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-test.xml");
        TestEvent testEvent = new TestEvent("hello", "message");
        context.publishEvent(testEvent);
    }
}
