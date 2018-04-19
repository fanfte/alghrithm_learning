package com.fanfte.singleton;

public class ClassSingleton {

    private static class SingletonHolder {
        public static ClassSingleton singleton = new ClassSingleton();
    }

    public static ClassSingleton getInstance() {
        return SingletonHolder.singleton;
    }
}
