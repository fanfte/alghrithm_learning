package com.fanfte.algorithm.dp;

public class LCUniquePath2 {

    public static void main(String[] args) {
        int[][] road = new int[][] {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(new LCUniquePath2().uniquePathsWithObstacles(road));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 :0;
        if(dp[0][0] == 0) {
            return 0;
        }

        for(int i = 0;i < dp.length;i++) {
            for(int j = 0;j < dp[0].length;j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if(j == 0) {
                    if(i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if(i == 0) {
                    if(j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
