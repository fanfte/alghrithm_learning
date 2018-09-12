package com.fanfte.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * Created by dell on 2018/8/2
 **/
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ": Thread Id: " + Thread.currentThread().getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 20, 0L
                , TimeUnit.MILLISECONDS
                , new LinkedBlockingDeque<>(1024)
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            pool.execute(task);
//            Future<?> submit = pool.submit(task);
//            Object o = null;
//            try {
//                o = submit.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println(o);
        }
        pool.shutdown();
    }
}
