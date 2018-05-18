package com.fanfte.algorithm.base;

public class LC344ReverseString {

    public static void main(String[] args) {
        System.out.println(new LC344ReverseString().reverseString("hello"));
    }

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while(l < r) {
            swap(chars, l, r);
            l++;
            r--;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
}
