package com.fanfte.designPattern.proxy.cglib;

/**
 * Created by dell on 2018/7/19
 **/
public class TestCglibProxy {

    public static void main(String[] args) throws Exception {
        Student instance = (Student) new Helper().getInstance(Student.class);
        instance.findLove();
    }
}
