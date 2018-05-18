package com.fanfte.algorithm.base;

public class LC167TwoSum2 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int res[] = new int[2];
        while(l < r) {
            if(numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if(numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
