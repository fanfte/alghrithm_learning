package com.fanfte.algorithm.dp;

import java.util.Arrays;

public class IntegerBreakMemSearch {

    int[] mem ;

    public static void main(String[] args) {
        IntegerBreakMemSearch integerBreak = new IntegerBreakMemSearch();
        System.out.println(integerBreak.integerBreak(4));
    }

    public int integerBreak(int n) {
        mem = new int[n + 1];
        Arrays.fill(mem, -1);

        int res = 0;
        mem[1] = 1;
        for(int i = 2;i <= n;i++) {
            for(int j = 1; j <= i - 1;j++ ) {
                res = max3(mem[i], j * (i - j), j * mem[i - j]);
            }
        }
        return integerSplit(n);
    }

    public int integerSplit(int n) {
        if(n == 1) {
            return 1;
        }
        if(mem[n] != -1) {
            return mem[n];
        }
        int res = 0;
        for(int i = 1;i <= n - 1;i++ ) {
            res = max3(res, i * (n - i), integerSplit(n - i));
        }
        mem[n] = res;
        return res;
    }

    public int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }


}
