package com.fanfte.spring;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by tianen on 2018/11/22
 *
 * @author fanfte
 * @date 2018/11/22
 **/
public class TestPropertyConfig {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application-test.xml"));
        BeanFactoryPostProcessor processor = (BeanFactoryPostProcessor) xmlBeanFactory.getBean("stringPostProcessor");
        processor.postProcessBeanFactory(xmlBeanFactory);
        HelloMessage message = (HelloMessage) xmlBeanFactory.getBean("helloMessage");
        System.out.println(message.getName());
    }
}
