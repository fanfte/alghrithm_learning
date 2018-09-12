package com.fanfte.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by tianen on 2018/9/7
 *
 * @author fanfte
 * @date 2018/9/7
 **/
public class DemoEvent extends ApplicationEvent {

    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
