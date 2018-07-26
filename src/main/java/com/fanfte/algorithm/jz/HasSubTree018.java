package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/18
 **/
public class HasSubTree018 {

    public boolean hasSubTree(BinaryTreeNode node1, BinaryTreeNode node2) {
        boolean result = false;
        if(node1 != null && node2 != null) {
            if(node1.value == node2.value) {
                result = doesTree1HaveTree2(node1, node2);
            }
            if(!result) {
                result = doesTree1HaveTree2(node1.left, node2);
            }
            if(!result) {
                result = doesTree1HaveTree2(node1.right, node2);
            }
        }
        return result;
    }

    private boolean doesTree1HaveTree2(BinaryTreeNode node1, BinaryTreeNode node2) {
        boolean result = false;
        if(node1 == null) {
            return false;
        }
        if(node2 == null) {
            return true;
        }
        if(node1.value != node2.value) {
            return false;
        }
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}
