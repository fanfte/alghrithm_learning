package com.fanfte.rpc.spi;


import java.util.ServiceLoader;

/**
 * Created by tianen on 2018/9/30
 *
 * @author fanfte
 * @date 2018/9/30
 **/
public class Main {

    public static void main(String[] args) {
        ServiceLoader<ISayName> load = ServiceLoader.load(ISayName.class);
        for (ISayName iSayName : load) {
            iSayName.say();
        }
    }
}
