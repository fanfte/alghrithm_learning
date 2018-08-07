package com.fanfte.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2018/8/2
 **/
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ": THread Id: " + Thread.currentThread().getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.submit(task);
        }
        pool.shutdown();
    }
}
