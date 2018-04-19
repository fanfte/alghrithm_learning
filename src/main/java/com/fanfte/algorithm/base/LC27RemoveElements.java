package com.fanfte.algorithm.base;

public class LC27RemoveElements {

    public int removeElement(int[] nums, int val) {
        int nonValIndex = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != val) {
                nums[nonValIndex ++] = nums[i];
            }
        }
        return nonValIndex;
    }

    public static void main(String[] args) {

    }
}
