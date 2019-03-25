package com.fanfte.jvm;

import java.util.Vector;

/**
 * Created by tianen on 2019/1/3
 *
 * @author fanfte
 * @date 2019/1/3
 **/
public class MaxHeapSize {

    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 1; i <= 10 ; i++) {
            byte[] b = new byte[1024 * 1024];
            v.add(b);
            System.out.println(i + "M is allocated");
        }
        System.out.println("Max memory:" + Runtime.getRuntime().maxMemory() / 1024 /1024 + "M");
    }
}
