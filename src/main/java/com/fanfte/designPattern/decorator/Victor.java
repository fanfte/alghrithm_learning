package com.fanfte.designPattern.decorator;

/**
 * Created by tianen on 2018/9/28
 *
 * @author fanfte
 * @date 2018/9/28
 **/
public class Victor implements Hero {
    @Override
    public void init() {
        System.out.println("victor weapon : guns");
    }
}
