package com.fanfte.algorithm.dp;

import java.util.Arrays;

public class LC300LISLength {

    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0;i < nums.length;i++) {
            for(int j = 0; j <= i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int[] getLISDp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 0;i < nums.length;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public int[] generateLIS(int[] arr, int[] dp) {
        int index = 0;
        int len = 0;
        for(int i = 0; i < dp.length;i++) {
            if(dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] res = new int[len];
        res[--len] = arr[index];
        for(int i = index;i >= 0;i --) {
            if(arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                res[--len] = arr[i];
                index = i;
            }
        }
        return res;
    }
}
