package com.fanfte.algorithm;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        bubbleSort(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0;i < arr.length - 1;i ++) {
            for(int j = 0; j < arr.length - i - 1;j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
