package com.fanfte.jvm;

/**
 * Created by tianen on 2019/1/3
 *
 * @author fanfte
 * @date 2019/1/3
 **/
public class WordReUse {

    public void test1() {
        {
            int a = 0;
        }
        long b = 0;
    }

    public void test2() {
        long a = 0;
        long b = 0;
    }

    public static void main(String[] args) {

    }
}
