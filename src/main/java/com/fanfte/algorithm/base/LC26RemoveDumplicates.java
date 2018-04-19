package com.fanfte.algorithm.base;

public class LC26RemoveDumplicates {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int pre = 0;

        for(int i = 1;i < nums.length;i++) {
            if(nums[i] > nums[pre]) {
                nums[++pre] = nums[i];
            }
        }
        return pre + 1;
    }

    public static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};

        printArr(arr);
        removeDuplicates(arr);
        System.out.println(arr);
    }
}
