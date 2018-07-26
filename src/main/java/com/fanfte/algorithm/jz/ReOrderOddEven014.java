package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/18
 **/
public class ReOrderOddEven014 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        new ReOrderOddEven014().reOrder(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void reOrder(int[] arr) {
        int evenIndex = 0;
        int oddIndex = arr.length - 1;
        if(arr == null || arr.length < 2) {
            return;
        }

        while(evenIndex < oddIndex) {
            while(evenIndex < oddIndex && (arr[evenIndex] & 0x1) != 0) {
                evenIndex ++;
            }
            while(evenIndex < oddIndex && (arr[oddIndex] & 0x1) == 0) {
                oddIndex --;
            }
            if(evenIndex < oddIndex) {
                swap(arr, evenIndex, oddIndex);
            }
        }
    }

    private void swap(int[] arr, int evenIndex, int oddIndex) {
        int temp = arr[evenIndex];
        arr[evenIndex] = arr[oddIndex];
        arr[oddIndex] = temp;
    }
}
