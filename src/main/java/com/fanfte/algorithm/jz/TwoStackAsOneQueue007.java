package com.fanfte.algorithm.jz;

import java.util.Stack;

/**
 * Created by dell on 2018/7/17
 **/
public class TwoStackAsOneQueue007 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        TwoStackAsOneQueue007 queue = new TwoStackAsOneQueue007();
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(7);
        queue.add(9);
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public void add(int pushNum) {
        stack1.add(pushNum);
    }

    public boolean isEmpty() {
        return stack1.empty() && stack2.empty();
    }

    public int poll() {
        if(stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty.");
        } else if(stack2.empty()){
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
