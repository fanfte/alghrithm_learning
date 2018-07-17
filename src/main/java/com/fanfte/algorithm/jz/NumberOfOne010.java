package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/17
 **/
public class NumberOfOne010 {

    public static void main(String[] args) {
        System.out.println(new NumberOfOne010().numOfOne(8));
    }

    int numOfOne(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n - 1);
            count ++;
        }
        return count;
    }
}
