package com.fanfte.designPattern.delegate;

/**
 * Created by dell on 2018/7/25
 **/
public class WorkerB implements IExecutor{
    @Override
    public void doSomething() {
        System.out.println("B doing something.");
    }
}
