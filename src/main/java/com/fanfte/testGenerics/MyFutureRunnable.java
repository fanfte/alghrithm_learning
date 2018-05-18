package com.fanfte.testGenerics;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface MyFutureRunnable<V> extends Runnable,Future<V> {

    void run();
}
