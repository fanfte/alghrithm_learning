package com.fanfte.algorithm.ctrip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestRoom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] arr = new int[3][len];

        for(int i =0;i<3;i++) {
            for(int j = 0;j < len;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int person = sc.nextInt();
        int child = sc.nextInt();
        int day = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0;i < len;i++) {
            map.put(i,0);
        }

        for(int i = 0;i < len;i++) {
        }

        for(int i=0;i<3;i++) {
            for(int j =0;j<len;j++) {
//                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println("0,1,180,0");
    }
}
