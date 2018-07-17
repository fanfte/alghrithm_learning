package com.fanfte.algorithm.jz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2018/7/17
 **/
public class RebuildBinaryTree006 {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = new RebuildBinaryTree006().rebuildPreIn(pre, in);
        System.out.println();
    }

    public void printTreeNode(TreeNode node) {
        System.out.println();
    }

    public TreeNode rebuildPreIn(int[] pre, int[] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ;i < in.length; i++ ){
            map.put(in[i], i);
        }

        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    public TreeNode preIn(int[] pre, int pi, int pj, int[] in, int ni, int nj, Map<Integer, Integer> keyMap) {
        if(pi > pj) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pi]);
        Integer index = keyMap.get(pre[pi]);
        head.left = preIn(pre, pi + 1, pi + index - ni, in, ni, index - 1, keyMap);
        head.right = preIn(pre, pi + index - ni + 1, pj, in, index + 1, nj, keyMap);
        return head;
    }

    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value) {
            this.value = value;
        }
    }

}
