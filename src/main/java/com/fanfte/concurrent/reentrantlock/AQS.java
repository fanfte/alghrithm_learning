package com.fanfte.concurrent.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianen on 2018/9/12
 *
 * @author fanfte
 * @date 2018/9/12
 **/
public class AQS {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ReentrantLockTask(), "thread" + i).start();
        }
    }

    public static class ReentrantLockTask implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " started. ");
            try {
                lock.lock();
                System.out.println("Thread " + Thread.currentThread().getName() + "get lock.------");
            } finally {
                lock.unlock();
            }
        }
    }
}
