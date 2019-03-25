package com.fanfte.jvm;

/**
 * Created by tianen on 2019/1/3
 *
 * @author fanfte
 * @date 2019/1/3
 **/
public class GCTest1 {

    public static void test1() {
        {
            byte[] b = new byte[6 * 1024 * 1024];
        }

        System.gc();
        System.out.println("first explict gc over");
    }

    public static void main(String[] args) {
        test1();
        System.gc();
        System.out.println("first explict gc over");
    }
}
