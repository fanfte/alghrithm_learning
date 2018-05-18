package com.fanfte.algorithm.base;

public class LC125ValidPalindrome {


    public static void main(String[] args) {
        System.out.println(new LC125ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while(l < r) {
            if(!Character.isLetterOrDigit(chars[l])) {
                l++;
            }else if(!Character.isLetterOrDigit(chars[r])) {
                r--;
            }else {
                if(chars[l] == chars[r]) {
                    l++;
                    r--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
