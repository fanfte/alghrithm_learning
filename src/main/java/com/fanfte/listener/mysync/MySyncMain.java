package com.fanfte.listener.mysync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by tianen on 2018/11/6
 *
 * @author fanfte
 * @date 2018/11/6
 **/
public class MySyncMain {

    public static void main(String[] args) {

        MyPromise promise = new MyPromise();
        Executor executor = Executors.newFixedThreadPool(1);

        Task t = new Task();

        executor.execute(new MyRunnable<String>(promise) {
            @Override
            public String doWork() {
                return t.doTask("world");
            }
        });

        promise.addListener(new MyListener() {
            @Override
            public void operationComplete(MyPromise promise) {
                String result;
                if(promise.isSuccess()) {
                    result = (String) promise.get();
                    System.out.println(result);
                } else {
                    Exception e = (Exception) promise.get();
                    e.printStackTrace();
                }
            }
        });

    }
}
