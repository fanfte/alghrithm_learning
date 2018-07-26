package com.fanfte.designPattern.delegate;

/**
 * Created by dell on 2018/7/25
 **/
public class TestDelegate {

    public static void main(String[] args) {
        Boss boss = new Boss(new WorkerA());
        boss.doSomething();
    }
}
