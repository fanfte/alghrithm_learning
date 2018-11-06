package com.fanfte.java8.test;

/**
 * Created by tianen on 2018/8/22
 *
 * @author fanfte
 * @date 2018/8/22
 **/
public class TestThread {

    private static int c = 1;

    private static Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            c = 2;
            System.out.println(c);
        }
    });

    static {
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("OK");
    }
}
