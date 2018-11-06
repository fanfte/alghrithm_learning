package com.fanfte.java8.test;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by dell on 2018/7/31
 **/
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
