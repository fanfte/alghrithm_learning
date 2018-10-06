package com.fanfte.testGenerics;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable =  new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
//        FutureTask<Integer> future = new FutureTask<>(callable);
//        ExecutorService es = Executors.newCachedThreadPool();
//        Future<?> result = es.submit(future);
//        es.shutdown();
//        System.out.println(future.get());
    }
}
