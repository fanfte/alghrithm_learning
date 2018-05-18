package com.fanfte.effectivejava.chapter2;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable{

    private int size = 0;

    private Object[] elements;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if(this.size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    protected Stack clone() throws CloneNotSupportedException {
        Stack result = (Stack) super.clone();
        result.elements = this.elements.clone();
        return result;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Stack stack1 = new Stack();
        Stack stack2 = stack1.clone();
        stack1.push("asdsad");
        stack1.push("vfs");
        System.out.println();
    }
}
