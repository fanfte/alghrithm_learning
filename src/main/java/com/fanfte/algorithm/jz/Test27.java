package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/27
 **/
public class Test27 {

    public static BinaryTreeNode convert(BinaryTreeNode node) {
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
        convertNode(node, lastNode);
        BinaryTreeNode head = lastNode[0];
        while(head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    /**
     *
     * @param node          当前节点
     * @param lastNode      已经转换完成的链表的尾节点
     */
    private static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode) {
        if(node != null) {
            if(node.left != null) {
                convertNode(node.left, lastNode);
            }
            node.left = lastNode[0];

            // 左子树转换完成最终节点不为null
            if(lastNode[0] != null) {
                lastNode[0].right = node;
            }
            // 当前节点为尾节点
            lastNode[0] = node;

            // 处理右子树
            if(node.right != null) {
                convertNode(node.right, lastNode);
            }
        }
    }

    private static void printList(BinaryTreeNode node) {
        while(node != null) {
            System.out.print(node.value + "->");
            node = node.right;
        }
        System.out.println("null");
    }

    private static void test01() {
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.value = 10;
        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.value = 6;
        BinaryTreeNode node14 = new BinaryTreeNode();
        node14.value = 14;
        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;
        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.value = 8;
        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.value = 12;
        BinaryTreeNode node16 = new BinaryTreeNode();
        node16.value = 16;
        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        BinaryTreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    private static void printTree(BinaryTreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.print(root.value + "->");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        test01();
    }
}
