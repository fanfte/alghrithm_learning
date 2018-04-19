package com.fanfte.algorithm.base;

public class LC283MoveZeros {

    public static void moveZeroes(int[] nums) {
        int resIndex = 0;
        int nonZeroIndex = 0;

        //找到非0元素放置到resIndex位置上，resIndex递增
        while(nonZeroIndex < nums.length) {
            if(nums[nonZeroIndex] != 0) {
                nums[resIndex ++] = nums[nonZeroIndex];
            }
            nonZeroIndex ++;
        }
        //nonZeroIndex元素后面的元素都赋值为0
        for(int i = nonZeroIndex ;i < nums.length;i++) {
            nums[i] = 0;
        }
        System.out.println();
    }

    /**
     * 非零元素和零元素交换
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;

        for(int i = 0;i <nums.length;i++) {
            if(nums[i] != 0 ) {
                if(i != nonZeroIndex) {
                    swap(nums, nonZeroIndex , i);
                }
                nonZeroIndex ++;
            }
        }
    }

    private static void swap(int nums[], int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {

    }
}
