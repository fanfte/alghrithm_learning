package com.fanfte.concurrent.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tianen on 2018/10/25
 *
 * @author fanfte
 * @date 2018/10/25
 **/
public class TestAutomicInteger {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.getAndIncrement());
    }
}
