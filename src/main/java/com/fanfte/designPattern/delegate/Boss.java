package com.fanfte.designPattern.delegate;

/**
 * Created by dell on 2018/7/25
 **/
public class Boss implements IExecutor{

    private IExecutor executor;

    public Boss(IExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void doSomething() {
        executor.doSomething();
    }
}
