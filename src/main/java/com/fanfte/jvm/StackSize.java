package com.fanfte.jvm;

import com.fanfte.myannotation.annotation.Test;

/**
 * Created by tianen on 2019/1/3
 *
 * @author fanfte
 * @date 2019/1/3
 **/
public class StackSize {

    private static int count = 0;
    public static void recursion(long a, long b, long c) throws Exception {
        long d = 0, e = 0, f = 0;
        count ++;
        recursion(a, b, c);
    }

    public static void main(String[] args) {
        try {
            recursion(1L, 2L, 3L);
        } catch (Throwable e) {
            System.out.println("statck depth is " + count);
            e.printStackTrace();
        }
    }

    public void testStack() {
        try {
            recursion(1L, 2L, 3L);
        } catch (Throwable e) {
            System.out.println("stack depth is " + count);
            e.printStackTrace();
        }
    }
}
