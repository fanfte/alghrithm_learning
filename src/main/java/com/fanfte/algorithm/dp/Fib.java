package com.fanfte.algorithm.dp;

import java.util.Arrays;

public class Fib {

    private static int[] mem ;

    public static int fib(int n) {
        if(n ==0 ) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(mem[n] == -1) {
            mem[n] = fib(n - 1) + fib(n - 2);
        }
        return mem[n];
    }

    public static void main(String[] args) {
        int n = 30;
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        double startTime = System.currentTimeMillis();
        int res = fib2(n);
        System.out.println("res " + res);
        double endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms ");
    }

    public static int fib2(int n) {
        mem[0] = 0;
        mem[1] = 1;
        for(int i = 2;i <= n;i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }
}
