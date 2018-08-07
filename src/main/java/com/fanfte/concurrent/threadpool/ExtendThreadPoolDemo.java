package com.fanfte.concurrent.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/8/2
 **/
public class ExtendThreadPoolDemo {

    static class NewTask implements Runnable {

        private String name;

        public NewTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行Thread Id: " + Thread.currentThread().getId() + "name: " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行： " + ((NewTask) r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成： " + ((NewTask) r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程终止");
            }
        };
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new NewTask("Newtask " + i));
        }
        threadPoolExecutor.shutdown();
    }
}
