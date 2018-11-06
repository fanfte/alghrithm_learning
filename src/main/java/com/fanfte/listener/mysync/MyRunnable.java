package com.fanfte.listener.mysync;

/**
 * Created by tianen on 2018/11/6
 *
 * @author fanfte
 * @date 2018/11/6
 **/
public abstract class MyRunnable<V> implements Runnable {

    final MyPromise myPromise;

    public MyRunnable(MyPromise myPromise) {
        this.myPromise = myPromise;
    }

    @Override
    public void run() {
        try {
            V v = doWork();
            myPromise.setSuccess(v);
        } catch (Exception e) {
            myPromise.setFailure(e);
        }
    }

    public abstract V doWork();
}
