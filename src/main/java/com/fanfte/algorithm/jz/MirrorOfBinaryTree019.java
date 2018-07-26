package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/23
 **/
public class MirrorOfBinaryTree019 {

    public void mirrorOfTree(BinaryTreeNode node) {
        if(node == null) {
            return;
        }

        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirrorOfTree(node.left);
        mirrorOfTree(node.right);
    }
}
