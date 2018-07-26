package com.fanfte.algorithm.jz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/7/25
 **/
public class Test025 {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 10;
        root.left = new BinaryTreeNode();
        root.left.value = 5;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 4;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 12;

        findPath(root, 22);
    }

    public static void findPath(BinaryTreeNode node, int sum) {
        if(node == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        if(node != null) {
            findPath(node, 0, sum, list);
        }
    }

    private static void findPath(BinaryTreeNode node, int curSum, int sum, List<Integer> list) {
        if(node != null) {
            curSum += node.value;
            list.add(node.value);
            if(curSum < sum) {
                findPath(node.left, curSum, sum, list);
                findPath(node.right, curSum, sum, list);
            } else if(curSum == sum) {
                if(node.left == null && node.right == null) {
                    System.out.println(list);
                }
            }
            list.remove(list.size() - 1);
        }
    }
}
