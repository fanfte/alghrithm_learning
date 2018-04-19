package com.fanfte.algorithm.stack;

import java.util.Stack;

public class IsStackOrder {

    public static void main(String[] args) {

    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        int popIndex = 0;
        for(int i = 0;i < pushA.length;i++) {
            s.push(pushA[i]);
            while(!s.isEmpty() && s.peek() == popA[popIndex++]) {
                s.pop();
            }
        }
        return s.isEmpty();
    }
}
