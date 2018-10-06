package com.fanfte.rpc.test;

import com.fanfte.rpc.framework.RpcFramework;

/**
 * Created by tianen on 2018/9/18
 *
 * @author fanfte
 * @date 2018/9/18
 **/
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }

}
