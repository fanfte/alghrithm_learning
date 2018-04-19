package com.fanfte.algorithm.dp;

public class LC91DecodeWays {

    public static void main(String[] args) {
        LC91DecodeWays lc = new LC91DecodeWays();
        System.out.println(lc.numDecodings("123"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];

        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for(int i = n - 2;i >= 0;i--) {
            if(s.charAt(i) == '0') {
                continue;
            }else {
                dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        return dp[0];
    }
}
