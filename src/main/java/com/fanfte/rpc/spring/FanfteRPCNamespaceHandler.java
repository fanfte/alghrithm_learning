package com.fanfte.rpc.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by tianen on 2018/11/8
 *
 * @author fanfte
 * @date 2018/11/8
 **/
public class FanfteRPCNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("reference", new FanfteRPCBeanDefinitionParser());
    }
}
