package com.fanfte.algorithm.dp;

import java.util.Arrays;

public class LCUniquePaths {

    public static void main(String[] args) {
        LCUniquePaths lc = new LCUniquePaths();
        System.out.println(lc.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {
        //只能往下和往右走，所以第一行和第一列的走法都是1
        int dp[][] = new int[m][n];
        for(int i = 0;i < m;i++) {
            dp[i][0] = 1;
        }
        for(int i = 0;i < n;i++) {
            dp[0][i] = 1;
        }

        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
     }
}
