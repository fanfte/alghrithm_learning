package com.fanfte.concurrent.juc;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tianen on 2018/10/25
 *
 * @author fanfte
 * @date 2018/10/25
 **/
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue<>(1024);
        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> {
                int j = 0;
                while(true) {
                    try {
                        linkedBlockingQueue.put(num + "号线程的" + j + "号商品");
                        j ++;
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while(true) {
                    try {
                        System.out.println("消费了" + linkedBlockingQueue.take());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }

}
