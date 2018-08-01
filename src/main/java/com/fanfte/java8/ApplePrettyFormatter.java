package com.fanfte.java8;

/**
 * Created by dell on 2018/7/31
 **/
public class ApplePrettyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple a) {
        return "An apple weight = " + a.getWeight() + " color " + a.getColor();
    }
}
