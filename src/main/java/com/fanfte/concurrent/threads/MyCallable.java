package com.fanfte.concurrent.threads;

import java.util.concurrent.Callable;

/**
 * Created by tianen on 2019/3/18
 *
 * @author fanfte
 * @date 2019/3/18
 **/
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("ready to work");
        Thread.currentThread().sleep(2000);
        System.out.println("task done");
        return value;
    }
}
