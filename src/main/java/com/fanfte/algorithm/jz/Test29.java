package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/8/3
 **/
public class Test29 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(arr));
        int[] leastKNums = getLeastKNums(arr, 4);
        printList(leastKNums);
    }

    public static void printList(int[] arr) {
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] getLeastKNums(int[] arr, int k) {
        int[] result = new int[k];
        int end = arr.length - 1;
        int start = 0;
        int index = partition(arr, start, end);

        while(index != k - 1) {
           if(index > k - 1) {
                end = index - 1;
                index = partition(arr, start, end);
           } else {
               start = index + 1;
               index = partition(arr, start, end);
           }
        }
        for (int i = 0; i <= k - 1; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static int partition(int[] arr, int left, int right) {
        int position = left;
        int temp = arr[left];
        while(left < right) {
            while(left < right && arr[right] >= temp ) {
                right --;
            }
            while(left < right && arr[left] <= temp ) {
                left ++;
            }
            if(left < right) {
                swap(arr, left, right);
            }
        }
        arr[position] = arr[left];
        arr[left] = temp;
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static int moreThanHalfNum(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }

        int middle = arr.length >> 1;
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        while(index != middle) {
            if(index > middle) {
                end = index - 1;
                index = partition(arr, start, end);
            } else {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        int result = arr[middle];
        return result;
    }
}
