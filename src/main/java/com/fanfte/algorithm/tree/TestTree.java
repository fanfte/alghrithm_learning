package com.fanfte.algorithm.tree;

public class TestTree {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(4);
        node.right = new Node(5);
        node.left.left = new Node(6);
        node.left.right = new Node(7);
        node.right.left = new Node(8);
        node.right.right = new Node(9);

        preOrderRecur(node);
    }

    public static void preOrderRecur(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.value + "");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    public static void inOrderRecur(Node node) {
        if(node == null) {
            return;
        }
        inOrderRecur(node.left);
        System.out.println(node.value + "");
        inOrderRecur(node.right);
    }

    public static void posOrderRecur(Node node) {
        if(node ==null) {
            return;
        }
        posOrderRecur(node.left);
        posOrderRecur(node.right);
        System.out.println(node.value);
    }
}
