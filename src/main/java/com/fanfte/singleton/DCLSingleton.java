package com.fanfte.singleton;

public class DCLSingleton {

    private static volatile DCLSingleton singleton;

    public static DCLSingleton getInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
