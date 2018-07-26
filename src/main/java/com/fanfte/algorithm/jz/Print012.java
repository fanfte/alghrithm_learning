package com.fanfte.algorithm.jz;

import java.util.Arrays;

/**
 * Created by dell on 2018/7/18
 **/
public class Print012 {

    public static void main(String[] args) {
        new Print012().print1ToMaxOfNDigits(10);
    }

    public void print1ToMaxOfNDigits(int n) {
        if(n < 0) {
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        while(!increment(chars)) {
            printNumber(chars);
        }
    }

    private void printNumber(char[] chars) {
        boolean isBeginning0 = true;
        for(int i = 0;i < chars.length; i++) {
            if(isBeginning0 && '0' != chars[i]) {
                isBeginning0 = false;
            }
            if(!isBeginning0) {
                System.out.print(chars[i]);
            }
        }
        System.out.println();
    }

    private boolean increment(char[] chars) {
        boolean isOverflow = false;
        int len = chars.length;
        int takeOver = 0;
        for(int i = len - 1; i >= 0;i--) {
            int nSum = chars[i] - '0' + takeOver;
            if(i == len - 1) {
                nSum ++;
            }
            if(nSum >= 10) {
                if(i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    takeOver = 1;
                    chars[i] = (char) (nSum + '0');
                }
            } else {
                chars[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }


}
