package com.fanfte.algorithm.jz;

import java.util.Stack;

/**
 * Created by dell on 2018/7/23
 **/
public class StackWithMin021 {

    public static void main(String[] args) {
        StackWithMin021 minStack = new StackWithMin021();
        minStack.push(4);
        minStack.push(3);
        minStack.push(6);
        minStack.push(1);
        minStack.push(-1);
        minStack.push(8);
        System.out.println(minStack.pop());
    }

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2=  new Stack<>();

    public void push(int num) {
        stack1.push(num);
        if(stack2.isEmpty() || stack1.peek() > num) {
            stack2.push(num);
        } else {
            stack2.push(stack1.peek());
        }
    }

    public Integer pop() {
        if(stack1.isEmpty()) {
            throw  new RuntimeException("Stack is empty.");
        }
        return stack1.pop();
    }

    public int getMin() {
        if(stack2.isEmpty()) {
            throw  new RuntimeException("Stack has no element");
        }
        return stack2.peek();
    }
}
