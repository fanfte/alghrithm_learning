package com.fanfte.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by tianen on 2018/9/7
 *
 * @author fanfte
 * @date 2018/9/7
 **/
@Component
public class DemoPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String message) {
        applicationContext.publishEvent(new DemoEvent(this, message));
    }
}
