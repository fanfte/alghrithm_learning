package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/27
 **/
public class Test28 {

    public static void main(String[] args) {
        permutation("abc".toCharArray(), 0, "abc".length());
    }

    public static void permutation(char[] arr, int from, int to) {
        if(to <= 1) {
            return;
        }
        if(from == to) {
            System.out.println(arr);
        } else {
            for(int i = from ;i < to;i ++) {
                swap(arr, i, from);
                permutation(arr, from + 1, to);
                swap(arr, from ,i);
            }
        }
    }

    private static void swap(char[] arr, int i, int from) {
        char temp = arr[i];
        arr[i] = arr[from];
        arr[from] = temp;
    }
}
