package com.fanfte.rpc.service;

import org.springframework.stereotype.Service;

/**
 * Created by tianen on 2018/11/8
 *
 * @author fanfte
 * @date 2018/11/8
 **/
@Service("demoService")
public class DemoServiceImpl implements DemoService{
    @Override
    public String sayHello(String str) {
        return "Hello " + str;
    }
}
