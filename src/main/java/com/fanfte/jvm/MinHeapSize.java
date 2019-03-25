package com.fanfte.jvm;

import java.util.Vector;

/**
 * Created by tianen on 2019/1/3
 *
 * @author fanfte
 * @date 2019/1/3
 **/
public class MinHeapSize {

    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 1; i <= 10 ; i++) {
            byte[] b = new byte[1024 * 1024];
            v.add(b);
            if(v.size() == 3) {
                v.clear();
            }
        }
    }
}
