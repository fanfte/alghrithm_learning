package com.fanfte.algorithm.base;

public class LC3LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        char[] chars = s.toCharArray();
        int l = 0;
        int r = -1;
        int res = 0;
        while(l < chars.length) {
            if(r + 1 < chars.length && freq[chars[r + 1]] == 0) {
                freq[chars[++r]] ++;
            } else {
                freq[chars[l++]] --;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
