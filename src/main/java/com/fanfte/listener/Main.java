package com.fanfte.listener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by tianen on 2018/9/7
 *
 * @author fanfte
 * @date 2018/9/7
 **/
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("Hello world");
        context.close();
    }
}
