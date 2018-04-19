package com.fanfte.algorithm.dp;

import java.util.Arrays;

public class HouseRobber {

    private int[] mem ;

    public static void main(String[] args) {
        int[] house = new int[]{1,1,1,1};
        HouseRobber lc = new HouseRobber();
        System.out.println(lc.robDP(house));
    }

    /**
     * 递归方式暴力计算
     * @param nums
     * @return
     */
    public int robRecursive(int[] nums) {
        mem = new int[nums.length];
        Arrays.fill(mem, -1);
        return tryRobRecursive(0, nums);
    }

    /**
     * 递归方式暴力计算尝试从index到n - 1 之间的房屋中抢劫获取金额
     * @param index
     * @param nums
     * @return num value
     */
    public int tryRobRecursive(int index, int[] nums) {
        if(index >= nums.length) {
            return 0;
        }
        if(mem[index] != -1) {
            return mem[index];
        }
        int res = 0;
        for(int i = index;i < nums.length;i++) {
            res = Math.max(res, nums[i] + tryRobRecursive(i + 2, nums));
        }
        mem[index] = res;
        return mem[index];
    }

    /**
     * 记忆化搜索
     * @param index
     * @param nums
     * @return
     */
    public int tryRobSearch(int index, int[] nums) {
        if(index >= nums.length) {
            return 0;
        }
        int res = 0;
        for(int i = index;i < nums.length;i++) {
            res = Math.max(res, nums[i] + tryRobRecursive(i + 2, nums));
        }
        return res;
    }

    public int robDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if(n == 0) {
            return 0;
        }
        dp[n - 1] = nums[n - 1];
        for(int i = n - 2;i >= 0; i--) {
            for(int j = i;j < n;j++) {
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 < n ? dp[j + 2] : 0));
            }
        }
        return dp[0];
    }
}
