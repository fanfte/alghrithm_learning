package com.fanfte.algorithm.ctrip;

import java.util.Scanner;

public class TestZeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        int[] res = new int[len];
        for(int i =0;i < len;i++) {
            nums[i] = sc.nextInt();
        }

        int pos = 0;
        for(int i=0;i<len;i++) {
            if(nums[i] !=0) {
                res[pos++] = nums[i];
            }
        }
        for(int i =pos;i < len;i++) {
            res[pos++] = 0;
        }

        for(int i =0;i< len;i++) {
            System.out.print(res[i] + " ");
        }
    }
}
