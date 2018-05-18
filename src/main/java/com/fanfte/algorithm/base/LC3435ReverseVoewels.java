package com.fanfte.algorithm.base;

import java.util.HashSet;
import java.util.Set;

public class LC3435ReverseVoewels {

    public String reverseVowels(String s) {
        Set<Character> vos = new HashSet<>();
        vos.add('a');
        vos.add('e');
        vos.add('i');
        vos.add('o');
        vos.add('u');
        vos.add('A');
        vos.add('E');
        vos.add('I');
        vos.add('O');
        vos.add('U');
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while(l < r) {
            if(!vos.contains(chars[l])) {
                l ++;
            } else if(!vos.contains(chars[r])) {
                r--;
            } else {
                swap(chars, l, r);
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
}
