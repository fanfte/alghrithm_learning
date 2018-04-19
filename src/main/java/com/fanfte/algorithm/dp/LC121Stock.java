package com.fanfte.algorithm.dp;

public class LC121Stock {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        int tmpMax = 0;
        for(int i = 0;i < prices.length;i++) {
            if(prices[i] <= min) {
                min = prices[i];
            } else {
                tmpMax = Math.max(tmpMax, prices[i] - min);
            }
        }
        return tmpMax;
    }

    public int maxProfit122(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 0;i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                res += prices[i - 1] - prices[i];
            }
        }
        return  res;
    }

    public int maxProfit3(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoSell = 0;
        for(int i = 0;i < prices.length;i ++) {
            oneBuy = Math.max(oneBuy, -prices[i]);
            oneSell = Math.max(oneSell, oneBuy + prices[i]);
            twoBuy = Math.max(twoBuy, oneSell - prices[i]);
            twoSell = Math.max(twoSell, twoBuy + prices[i]);
        }
        return Math.max(oneSell, twoSell);
    }

    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        if(k > prices.length / 2) {
            return maxProfitAsc(prices);
        }
        int[][] hold = new int[prices.length][k + 1];
        int[][] unHold = new int[prices.length][k + 1];

        hold[0][0] = -prices[0];
        //unHold[0][0] = 0;
        for(int i = 1;i <= k;i ++) {
            hold[0][i] = -prices[0];
        }
        for(int i = 1;i < prices.length;i++) {
            hold[i][0] = Math.max(hold[i - 1][0], -prices[i]);
        }
        for(int i = 1;i < prices.length;i ++) {
            for(int j = 1;j <= k;j ++) {
                hold[i][j] = Math.max(hold[i - 1][j], unHold[i - 1][j] - prices[i]);
                unHold[i][j] = Math.max(hold[i - 1][j - 1] + prices[i], unHold[i - 1][j]);
            }
        }
        return Math.max(hold[prices.length - 1][k], unHold[prices.length - 1][k]);
    }

    //寻找最大的递增利润
    private int maxProfitAsc(int[] prices) {
        int res = 0;
        for(int i = 0;i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
