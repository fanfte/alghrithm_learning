package com.fanfte.algorithm.tree;

public class IsBalance {

    public static boolean isBalance(Node node) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(node, 1, res);
        return res[0];
    }

    public static int getHeight(Node node, int level, boolean[] res) {
        if(node == null) {
            return level;
        }
        int lH = getHeight(node.left, level + 1, res);
        if(!res[0]) {
            return level;
        }
        int rH = getHeight(node.right, level + 1, res);
        if(!res[0]) {
            return level;
        }
        if(Math.abs(lH - rH) > 1)  {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(4);
        node.right = new Node(5);
        node.left.left = new Node(6);
        node.left.right = new Node(7);
        node.right.left = new Node(8);
        node.right.right = new Node(9);
//        node.left.left.left = new Node(6);
//        node.left.left.left.left = new Node(6);
        boolean balance = isBalance(node);
        System.out.println(balance);
    }


}
