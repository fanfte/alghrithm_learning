package com.fanfte.algorithm.jz;

import java.math.BigDecimal;

/**
 * Created by tianen on 2018/12/10
 *
 * @author fanfte
 * @date 2018/12/10
 **/
public class Solution {

    public static void main(String[] args) {
        float f = 0.99f;
        System.out.println(new BigDecimal(f));
    }

    public int minNumberInRotateArray(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while(array[left] >= array[right]) {
            if(right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;
            if(array[left] == array[mid] && array[mid] == array[right]) {
                return getMinFromSub(array, left, right);
            }
            if(array[mid] >= array[left]) {
                left = mid;
            }
            if(array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[mid];
    }

    private int getMinFromSub(int[] array, int left, int right) {
        int num = array[left];
        for(int i = left + 1; i < right ;i++) {
            if(num < array[i]) {
                num = array[i];
            }
        }
        return num;
    }

    public void reOrderArray(int [] array) {
        int[] result = new int[array.length];
        int index = 0;
        for(int i = 0;i < array.length;i++) {
            if(!isEven(array[i])) {
                result[index ++] = array[i];
            }
        }
        for(int i = 0;i < array.length;i++) {
            if(isEven(array[i])) {
                result[index ++] = array[i];
            }
        }
        for(int i = 0;i < array.length;i++) {
            array[i] = result[i];
        }
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }
}
