package com.fanfte.algorithm.string;

/**
 * Created by tianen on 2018/11/12
 * 剑指offer34 丑数
 * @author fanfte
 * @date 2018/11/12
 **/
public class UglyNum {

    public static boolean isUgly(int number) {
        while(number % 2 == 0) {
            number /= 2;
        }
        while(number % 3 == 0) {
            number /= 3;
        }
        while(number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public static int getUglyNumber(int index) {
        if(index <= 0) {
            return 0;
        }
        int number = 0;
        int found = 0;
        while(found < index) {
            number ++;
            if(isUgly(number)) {
                found ++;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
//        System.out.println(getUglyNumber(1500));
        long end1 = System.currentTimeMillis();
        System.out.println("cost1 : " + (end1 - start1) );
        long start2 = System.currentTimeMillis();
        System.out.println(getUglyNumber2(1500));
        long end2 = System.currentTimeMillis();
        System.out.println("cost2 : " + (end2 - start2) );
    }

    public static int getUglyNumber2(int index) {
        if(index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index) {
            int min = min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while(uglyNumbers[p2] * 2 <= uglyNumbers[nextUglyIndex]) {
                p2 ++;
            }
            while(uglyNumbers[p3] * 3 <= uglyNumbers[nextUglyIndex]) {
                p3 ++;
            }
            while(uglyNumbers[p5] * 5 <= uglyNumbers[nextUglyIndex]) {
                p5 ++;
            }
            nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex - 1];
    }

    /**
     * 求三个数最小值
     * @return min
     */
    private static int min(int p2, int p3, int p5) {
        int min = (p2 < p3) ? p2 : p3;
        return (min < p5) ? min : p5;
    }
}
