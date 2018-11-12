package com.fanfte.rpc.spring;

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
public class UserBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String email = element.getAttribute("email");
        Integer age = Integer.parseInt(element.getAttribute("age"));
        if(StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if(StringUtils.hasText(name)) {
            builder.addPropertyValue("name", name);
        }
        if(StringUtils.hasText(email)) {
            builder.addPropertyValue("email", email);
        }
        if(age != null) {
            builder.addPropertyValue("aget", age);
        }
    }
}
