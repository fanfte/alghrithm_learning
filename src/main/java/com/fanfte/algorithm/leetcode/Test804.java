package com.fanfte.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by tianen on 2018/11/15
 *
 * @author fanfte
 * @date 2018/11/15
 **/
public class Test804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new TreeSet<>();

        for(int i = 0;i < words.length; i ++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(codes[words[i].charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
