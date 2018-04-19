package com.fanfte.algorithm.tree;

import java.util.Arrays;

public class MaxNode {

    public static void main(String[] args) {


        int[] input={13,4,5,6,12};
        int len=input.length;
        StringBuffer res =new StringBuffer();
        String[] strs=new String[len];

        for(int i=0;i<len;i++){
            strs[i]=String.valueOf(input[i]);
            System.out.print(strs[i]);
        }
        Arrays.sort(strs);
        for(int i=0;i<len;i++){
            res.append(strs[i]);
        }
        System.out.println(res);
    }

    public int getMaxNodeValue(Node node, int res) {
        if(node == null) {
            return node.value;
        }

        int leftMax = getMaxNodeValue(node.left, res);
        int rightMax = getMaxNodeValue(node.right, res);
        return Math.max(node.value, Math.max(leftMax, rightMax));
    }

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
