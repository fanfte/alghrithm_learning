package com.fanfte.rpc.spring;

import com.fanfte.rpc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianen on 2018/11/8
 *
 * @author fanfte
 * @date 2018/11/8
 **/
public class UserTagTest {

    @Autowired
    private DemoService demoService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/application-tag.xml");
        User user = (User) context.getBean("userTag");
        System.out.println(user.getAge() + " " + user.getEmail() + " " + user.getName());
    }
}
