package com.fanfte.algorithm.dp;

public class LCS {

    public static void main(String[] args) {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";

        String lcse = lcse(str1, str2);
        System.out.println(lcse);
    }

    public static int[][] getDP(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        int[][] dp = new int[m][n];

        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for(int i = 1; i < m;i++) {
            dp[i][0] = Math.max(dp[i - 1][0], chars1[i] == chars2[0] ? 1 : 0);
        }

        for(int j = 1;j < n;j++) {
            dp[0][j] = Math.max(dp[0][j  -1], chars1[0] == chars2[j] ? 1 : 0);
        }
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(chars1[i] == chars2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static String lcse(String str1, String str2) {
        if(str1 == null || str2 == null ||str1.equals("") || str2.equals("")) {
            return "";
        }
        int m = str1.length() - 1;
        int n = str2.length() - 1;
        int[][] dp = getDP(str1, str2);
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while(index >= 0 ) {
            if(m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else if(n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else{
                res[index--] = str1.charAt(m);
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }


}
