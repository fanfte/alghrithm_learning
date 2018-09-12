package com.fanfte.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/8/2
 **/
public class Test {

    static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println("running thread id: " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0l, TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//
//        for (int i = 0; i < 10; i++) {
//            threadPoolExecutor.execute(new MyTask());
//        }
//
//        threadPoolExecutor.shutdown();
        System.out.println((1 << 29) - 1 );
        System.out.println((-1) << 29 );
        System.out.println((-1) << 29 & (1 << 29) - 1);
    }
}
