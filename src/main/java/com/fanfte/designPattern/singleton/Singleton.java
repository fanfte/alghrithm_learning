package com.fanfte.designPattern.singleton;

/**
 * Created by dell on 2018/7/26
 **/
public class Singleton {

    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

    private Singleton() {

    }

    public static final Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }

}
