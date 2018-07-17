package com.fanfte.algorithm.jz;

import com.fanfte.algorithm.string.ReplaceSpace;

/**
 * Created by dell on 2018/7/17
 **/
public class ReplaceBlank004 {
    public static void main(String[] args) {
        String o = "i am fff";
        System.out.println(new ReplaceBlank004().replace(o));
    }

    public String replace(String original) {
        char[] chars = original.toCharArray();
        if(original == null || chars.length == 0 ) {
            return null;
        }
        int spaceNums = 0;

        for(int i = 0;i < chars.length; i ++) {
            if(chars[i] == ' ') {
                spaceNums ++;
            }
        }
        char[] result = new char[chars.length + 2 * spaceNums];
        int oldIndex = chars.length - 1;
        int newIndex = result.length - 1;
        while(oldIndex >= 0 ) {
            if(chars[oldIndex] == ' ') {
                result[newIndex --] = '0';
                result[newIndex --] = '2';
                result[newIndex --] = '%';
            } else {
                result[newIndex --] = chars[oldIndex];
            }
            oldIndex --;
        }
        return new String(result);
    }
}
