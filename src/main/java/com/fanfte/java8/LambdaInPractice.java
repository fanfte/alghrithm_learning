package com.fanfte.java8;

import java.util.Collections;
import java.util.List;

/**
 * Created by tianen on 2018/9/3
 *
 * @author fanfte
 * @date 2018/9/3
 **/
public class LambdaInPractice {

    public static void main(String[] args) {
        List<Object> list = Collections.emptyList();
        List<Object> objects = list.subList(1, list.size());
        System.out.println();
    }
}
