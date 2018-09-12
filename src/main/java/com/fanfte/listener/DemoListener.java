package com.fanfte.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by tianen on 2018/9/7
 *
 * @author fanfte
 * @date 2018/9/7
 **/
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String message = event.getMessage();

        System.out.println("接收到了消息 " + message);
    }
}
