package com.fanfte.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组元素全排列，元素不可重复
 */
public class Permute {

    private static final List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) {
            return res;
        }
        permuteList(res, new ArrayList<>(), nums);
        return res;
    }

    public static void permuteList(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0;i < nums.length;i++) {
                if(tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                permuteList(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
