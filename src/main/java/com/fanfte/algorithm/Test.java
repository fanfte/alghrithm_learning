package com.fanfte.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        int[] numInt = new int[1000];
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] nums = str.split("\\+");

        for(int i = 0 ;i < nums.length;i++) {
            int n = Integer.valueOf(nums[i]);
            numInt[n] = numInt[n] + 1;
        }
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for (int i = 0; i < numInt.length; i++) {
            if(numInt[i] != 0) {
                sb.append(i).append("*").append(numInt[i]).append("+");
                sum += numInt[i] * i;
            }
        }
        System.out.println(sb.toString().substring(0,sb.toString().length() - 1));
        System.out.println(sum);
    }
}
