package com.fanfte.rpc.spi;

/**
 * Created by tianen on 2018/9/30
 *
 * @author fanfte
 * @date 2018/9/30
 **/
public class SayEnglishName implements ISayName {
    @Override
    public void say() {
        System.out.println("John");
    }
}
