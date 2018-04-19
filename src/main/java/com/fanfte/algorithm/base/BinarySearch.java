package com.fanfte.algorithm.base;

public class BinarySearch {

    //在[l, r)区间内查找target
    public static int binarySearch(int[] aim, int n, int target) {
        int l = 0;
        int r = n;//在[l...r)范围内查找target
        while(l < r) {
            //l == r时，(l + r) / 2是无效的
            int mid = l + (r - l) / 2;
            if(aim[mid] == target) {
                return mid;
            }
            if(target > aim[mid]) {
                l = mid + 1;//target在[mid + 1...r)中
            } else {
                r = mid;//target在[l...mid)中
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int res = binarySearch(arr, arr.length - 1, 4);
        System.out.println(res);
    }
}
