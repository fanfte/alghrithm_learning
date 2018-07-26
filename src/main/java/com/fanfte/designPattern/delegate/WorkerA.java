package com.fanfte.designPattern.delegate;

/**
 * Created by dell on 2018/7/25
 **/
public class WorkerA implements IExecutor {
    @Override
    public void doSomething() {
        System.out.println("A doing something.");
    }
}
