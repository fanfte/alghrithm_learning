package com.fanfte.java8.test;

/**
 * Created by dell on 2018/8/7
 **/
public interface Converter<F, T> {
    T convert(F f);
}
