package com.fanfte.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 号码盘上的数字每个对应了几个字符串，输入一个数字字符串，得到对应可能匹配字符串
 */
public class LetterCombinations {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")){
            return null;
        }
        List<String> res = new ArrayList<String>();
        combination("", digits, 0, res);
        return res  ;
    }

    public static void combination(String prefix, String digits, int position, List<String> res) {
        if(position == digits.length()) {
            res.add(prefix);
            return ;
        }
        String letters = KEYS[digits.charAt(position) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, position + 1, res);
        }
    }

}
