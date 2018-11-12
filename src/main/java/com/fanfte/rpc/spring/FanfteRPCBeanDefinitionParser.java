package com.fanfte.rpc.spring;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by tianen on 2018/11/8
 *
 * @author fanfte
 * @date 2018/11/8
 **/
public class FanfteRPCBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return ReferenceBean.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String anInterface = element.getAttribute("interface");
        if(StringUtils.hasText(anInterface)) {
            builder.addPropertyValue("interfaceClass", anInterface);
        }
    }
}
