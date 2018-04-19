package com.fanfte.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {

        if(n < 0 || k < 0 || n < k) {
            return res;
        }
        generateCombination(n, k, 1, new ArrayList<>());
        return res;
    }

    public static void generateCombination(int n, int k, int start, List<Integer> temp) {
        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return ;
        }
        //优化思路是减枝， 进入本次循环时temp中已经存在temp.size()个元素，
        //需要寻找 n - (k - temp.size())个元素来填补满k个元素
        for(int i = start;i <= n -(k - temp.size());i++) {
            temp.add(i);
            generateCombination(n, k, i + 1, temp);
            temp.remove(temp.indexOf(i));
        }
    }
}
