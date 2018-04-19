package com.fanfte.algorithm.dp;

public class LC309MaxProfit {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if(prices.length <= 0) {
            return 0;
        }

        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];

        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for(int i = 0;i < prices.length;i ++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
    }
}
