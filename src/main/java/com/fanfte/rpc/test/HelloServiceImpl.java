package com.fanfte.rpc.test;

/**
 * Created by tianen on 2018/9/18
 *
 * @author fanfte
 * @date 2018/9/18
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
