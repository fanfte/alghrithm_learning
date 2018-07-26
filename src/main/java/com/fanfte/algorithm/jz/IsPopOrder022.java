package com.fanfte.algorithm.jz;

import java.util.Stack;

/**
 * Created by dell on 2018/7/23
 **/
public class IsPopOrder022 {

    public static boolean isPopOrder(int[] push, int[] pop) {
        if(push == null || push.length == 0 || pop == null || pop.length == 0) {
            return false;
        }

        int pushIndex = 0;
        int popIndex = 0;

        Stack<Integer> stack = new Stack<>();
        while(popIndex < pop.length) {
            while(pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                stack.push(push[pushIndex++]);
            }
            if(stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex ++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println(isPopOrder(push, pop1));
        System.out.println(isPopOrder(push, pop2));
        System.out.println(isPopOrder(push, pop3));
        System.out.println(isPopOrder(push, pop4));
    }
}
