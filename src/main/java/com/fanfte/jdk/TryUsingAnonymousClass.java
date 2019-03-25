package com.fanfte.jdk;

/**
 * Created by tianen on 2019/2/1
 *
 * @author fanfte
 * @date 2019/2/1
 **/
public class TryUsingAnonymousClass {

    public void useMyInterface() {
        final Integer number = 123;

        MyInterface myInterface = new MyInterface() {
            @Override
            public void doSomething() {

            }
        };
        myInterface.doSomething();
    }
}
