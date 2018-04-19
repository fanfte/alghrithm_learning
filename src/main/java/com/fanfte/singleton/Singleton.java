package com.fanfte.singleton;

public class Singleton {
    private static volatile Singleton singleton;
    private Singleton() {};

    public static Singleton getInstance() {
        if(singleton == null) {//第一个Check主要为了减少同步，singleton不为空直接返回
            synchronized (Singleton.class) {
                //第二个Check主要为了解决锁竞争下的问题，instance未被创建时，两个线程都在抢占同一把锁
                //线程A得到锁，new一个Instance，释放锁
                //线程B得到锁，发现已经有了一个
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
