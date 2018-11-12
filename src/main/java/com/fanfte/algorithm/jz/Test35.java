package com.fanfte.algorithm.jz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianen on 2018/11/12
 *
 * @author fanfte
 * @date 2018/11/12
 **/
public class Test35 {

    public static void main(String[] args) {
        System.out.println(findFirstNotRepeatingChar("google"));
        System.out.println(findFirstNotRepeatingChar("aabccbdd"));
        System.out.println(findFirstNotRepeatingChar("fanfteae"));
        System.out.println(findFirstNotRepeatingChar("acdvfrjkkk"));
    }

    public static char findFirstNotRepeatingChar(String s) {
        if(s == null || s.length() <= 0) {
            throw new IllegalArgumentException("Arg should not be empty");
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0;i < chars.length ;i++) {
            if(map.containsKey(chars[i])) {
                map.put(chars[i], -1);
            } else {
                map.put(chars[i], i);
            }
        }
        char result = '\0';
        int idx = Integer.MAX_VALUE;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if(entry.getValue() >= 0 && entry.getValue() < idx) {
                idx = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

}
