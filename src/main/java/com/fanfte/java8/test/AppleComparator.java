package com.fanfte.java8.test;

import java.util.Comparator;

/**
 * Created by dell on 2018/8/1
 **/
public class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple a1, Apple a2) {

        return ((Integer) a1.getWeight()).compareTo(a2.getWeight());
    }
}
