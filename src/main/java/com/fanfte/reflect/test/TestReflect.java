package com.fanfte.reflect.test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by dell on 2018/7/24
 **/
public class TestReflect {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        People people = People.class.getConstructor().newInstance();
        People people2 = People.class.getConstructor().newInstance();
        System.out.println(people == people2);
    }
}
