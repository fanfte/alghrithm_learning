package com.fanfte.algorithm.base;

public class LC11ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = Integer.MIN_VALUE;
        while(l < r) {
            if(height[l] < height[r]) {
                res = Math.max(res, (r - l) * height[l++]);
            } else {
                res = Math.max(res, (r - l) * height[r--]);
            }
        }
        return res;
    }
}
