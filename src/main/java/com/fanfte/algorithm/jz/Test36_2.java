package com.fanfte.algorithm.jz;

/**
 * Created by tianen on 2018/11/12
 *
 * @author fanfte
 * @date 2018/11/12
 **/
public class Test36_2 {

    public static int inversePairs(int[] data) {
        if(data == null || data.length <= 0) {
            throw new IllegalArgumentException("Array may not be null");
        }

        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return inversePairsCore(data, copy, 0, data.length - 1);
    }

    public static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if(start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j >= start + length + 1) {
            if(data[i] > data[j]) {
                copy[indexCopy] = data[i];
                indexCopy --;
                i --;
                count += j - (start + length);
            } else {
                copy[indexCopy] = data[j];
                indexCopy --;
                j --;
            }
        }
        while(i >= start) {
            copy[indexCopy --] = data[i --];
        }
        while(j >= start + length + 1) {
            copy[indexCopy --] = data[j --];
        }
        return count + left + right;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(arr));
    }
}
