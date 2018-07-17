package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/17
 **/
public class FindMinInArr008 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 1,1};
        System.out.println(new FindMinInArr008().min(arr));
    }

    public int min(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new RuntimeException("Num not found");
        }
        int index1 = 0;
        int index2 = arr.length - 1;
        int indexMid = 0;
        while(arr[index1] >= arr[index2]) {
            if(index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = index1 + (index2 - index1) / 2;
            if(arr[indexMid] == arr[index1] && arr[indexMid] == arr[index2]) {
                return MinInOrder(arr, index1, index2);
            }

            if(arr[indexMid] >= arr[index1]) {
                index1 = indexMid;
            } else if(arr[indexMid] <= arr[index2]) {
                index2 = indexMid;
            }
        }
        return arr[indexMid];
    }

    private int MinInOrder(int[] arr, int index1, int index2) {
        int result = arr[index1];
        for(int i = index1 + 1;i < index2; i++) {
            if(arr[i] < result) {
                return arr[i];
            }
        }
        return result;
    }
}
