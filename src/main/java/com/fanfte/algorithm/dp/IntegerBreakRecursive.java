package com.fanfte.algorithm.dp;

public class IntegerBreakRecursive {

    public static void main(String[] args) {
        IntegerBreakRecursive integerBreak = new IntegerBreakRecursive();
        System.out.println(integerBreak.integerBreak(4));
    }

    public int integerBreak(int n) {
        return integerSplit(n);
    }

    public int integerSplit(int n) {
        if(n == 1) {
            return 1;
        }

        int res = 0;
        for(int i = 1;i <= n - 1;i++ ) {
            res = max3(res, i * (n - i), integerSplit(n - i));
        }
        return res;
    }

    public int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }


}
