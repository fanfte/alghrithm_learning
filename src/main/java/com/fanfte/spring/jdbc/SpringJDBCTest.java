package com.fanfte.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by tianen on 2019/3/25
 *
 * @author fanfte
 * @date 2019/3/25
 **/
public class SpringJDBCTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
        UserService uerService = (UserService) context.getBean("userService");
        User u = new User();
        u.setAge(20);
        u.setName("fanfte");
        u.setSex("男");
        uerService.save(u);

        List<User> users = uerService.getUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("id: " + u.getId() + " age: " + u.getAge() + " name: " + u.getName() + " sex: " + u.getSex());
        }
    }
}
