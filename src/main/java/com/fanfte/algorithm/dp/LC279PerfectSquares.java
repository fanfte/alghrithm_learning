package com.fanfte.algorithm.dp;

import java.util.Arrays;

public class LC279PerfectSquares {

    public static void main(String[] args) {
        LC279PerfectSquares lc = new LC279PerfectSquares();
        System.out.println(lc.numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j * j <= i;j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
