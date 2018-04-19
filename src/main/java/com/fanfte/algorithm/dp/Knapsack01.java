package com.fanfte.algorithm.dp;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {

    }

    private int[][] mem ;

    public int knapsack01(int[] w, int[] v, int capacity) {
        int n = w.length;
        mem = new int[n][capacity + 1];
        Arrays.fill(mem, -1);
        return bestValue(w, v, n - 1, capacity);
    }

    private int bestValue(int[] w, int[] v, int index, int capacity) {
        if(index < 0 || capacity <= 0) {
            return 0;
        }
        if(mem[index][capacity] != -1) {
            return mem[index][capacity];
        }
        int res = bestValue(w, v, index - 1, capacity);
        if(capacity >= w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, capacity - w[index]));
        }
        mem[index][capacity] = res;
        return res;
    }
}
