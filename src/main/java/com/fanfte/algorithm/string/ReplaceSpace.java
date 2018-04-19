package com.fanfte.algorithm.string;

public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("l am cat");
        System.out.println(new ReplaceSpace().replaceSpace(s));
    }

    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for(int i = 0;i < str.length();i++) {
            if(str.charAt(i) == ' ') {
                spaceNum ++;
            }
        }

        int len = str.length();
        int newLen = len + spaceNum * 2;
        str.setLength(newLen);
        int indexOld = len - 1;
        int indexNew = newLen - 1;
        while(indexOld >=0 && indexOld <= len - 1) {
            if(str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew --, '0');
                str.setCharAt(indexNew --, '2');
                str.setCharAt(indexNew --, '%');
            } else {
                str.setCharAt(indexNew --, str.charAt(indexOld));
            }
            indexOld --;
        }
        return str.toString();
    }
}
