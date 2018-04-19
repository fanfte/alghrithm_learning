package com.fanfte.algorithm.tree;

public class MyReOrderTree {

    class TreeNode{
        private int value;
        public TreeNode(int value) {
            this.value = value;
        }
        private TreeNode left;
        private TreeNode right;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,4,7,3,5,6,8};
        int[] arr2 = new int[] {4,7,2,1,5,3,8,6};
        new ReorderTree().reConstructBinaryTree(arr1, arr2);
    }

    public TreeNode preInToTree(int[] pre, int[] in) {
        if(pre == null || in == null) {
            return null;
        }
        TreeNode n = re(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return n;
    }

    private TreeNode re(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if(startPre > endPre || startIn > endIn) {
            return  null;
        }
        TreeNode node = new TreeNode(pre[startPre]);
        for(int i = startIn; i <= endIn; i++) {
            if(pre[startPre] == in[i]) {
                node.left = re(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                node.right = re(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return node;
    }


}
