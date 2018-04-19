package com.fanfte.algorithm.base;

public class LC215KthLargest {

    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while(true) {
            int pos = partition(nums, left, right);
            if(pos == k - 1) {
                return nums[pos];
            }
            if(pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while(l <= r) {
            if(nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if(nums[l] > pivot) {
                l++;
            }
            if(nums[r] < pivot) {
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    public static void swap(int[] nums, int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(arr, 2);
        System.out.println(kthLargest);
    }
}
