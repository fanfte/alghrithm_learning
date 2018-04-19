package com.fanfte.algorithm.tree;


import java.util.Stack;

/**
 * 先序遍历二叉树
 */
public class PreOrder {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        printTree(node);

        inOrderPrint(node);

        printPosOrder(node);
    }

    public static void printTree(Node node) {
        if(node != null) {
            Stack<Node> s = new Stack<>();
            s.add(node);
            while(!s.isEmpty()) {
                node = s.pop();
                System.out.print(node.value + " ");
                if(node.right != null) {
                    s.push(node.right);
                }
                if(node.left != null) {
                    s.push(node.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderPrint(Node node) {
        System.out.println("in order");
        if(node != null) {
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || node != null) {
                if(node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    System.out.print(node.value + " ");
                    node = node.right;
                }
            }
        }
        System.out.println();
    }

    //后序遍历
    public static void printPosOrder(Node node) {
        if(node != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(node);
            while(!stack1.isEmpty()) {
                node = stack1.pop();
                stack2.push(node);
                //s1入栈顺序为先左后右，s1出栈顺序为先右后左，
                //s2入栈顺序为中右左，s2出栈顺序为左右中
                if(node.left != null) {
                    stack1.push(node.left);
                }
                if(node.right != null) {
                    stack1.push(node.right);
                }
            }
            //s2保存了所有的后序遍历顺序结果
            while(!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
    }
}
