package com.fanfte.designPattern.proxy;

/**
 * Created by dell on 2018/7/19
 **/
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello world." + name);
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Goodbye");
    }
}
