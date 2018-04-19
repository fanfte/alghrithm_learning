package com.fanfte.algorithm.base;

public class LC75SortColors {


    public static void main(String[] args) {

        int[] in = new int[]{1, 2, 0};
        sortColors2(in);
        for(int i = 0 ;i < in.length;i++) {
            System.out.print( in[i] + " ");
        }
    }
    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0;i < nums.length;i++) {
            count[nums[i]] ++;
        }

        int index = 0;
        for(int i = 0;i < count.length;i++) {
            for(int j = 0;j < count[i];j++) {
                nums[index ++] = i;
            }
        }
    }

    //三路快排实现
    public static void sortColors2(int[] nums) {
        int lt = 0;         //[l...lt)的数据<v
        int gt = nums.length;//[gt...r)的数据>v   r = nums.length - 1
        int i = 0;
        while(i < gt) {
            if(nums[i] == 2) {
                swap(nums, i, gt - 1);
                gt--;
            } else if(nums[i] == 0) {
                swap(nums, lt++, i++);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}
