package com.fanfte.algorithm.jz;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dell on 2018/7/25
 **/
public class PrintFromTopToBottom023 {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);
        printFromTopToBottom(root);
    }

    public static void printFromTopToBottom(BinaryTreeNode node) {
        if(node == null) {
            return;
        }

        List<BinaryTreeNode> queue = new ArrayList<>();
        queue.add(node);
        while(queue.size() > 0) {
            BinaryTreeNode peek = queue.get(0);
            System.out.print(peek.value + " ");
            queue.remove(0);
            if(peek.left != null) {
                queue.add(peek.left);
            }
            if(peek.right != null) {
                queue.add(peek.right);
            }
        }
    }
}
