package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/25
 **/
public class VerifySequenceOfBST024 {

    public static void main(String[] args) {
        int[] data4 = {7, 4, 6, 5};
        System.out.println(verifySequenceOfBST(data4, 0, data4.length - 1));
    }

    public static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if(start >= end) {
            return true;
        }
        int root = sequence[end];
        int i = start;
        for(; i < end; i ++) {
            if(sequence[i] > root) {
                break;
            }
        }
        int j = i;
        for(; j < end  - 1; j ++) {
            if(sequence[j] < root) {
                return false;
            }
        }
        return verifySequenceOfBST(sequence, start, i - 1) && verifySequenceOfBST(sequence, j, end - 1);
    }
}
