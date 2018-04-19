package com.fanfte.algorithm.list;

public class ReverseList {

    public static class Node {
        private int value;
        public Node(int value) {
            this.value = value;
        }
        private Node next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(4);

        printNode(node);
        printNode(reverse2(node));
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while(head != null) {
           next = head.next;
           head.next = pre;
           pre = head;
           head = next;
        }
        return pre;
    }

    public static Node reverse2(Node head) {
        Node pre = null;
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void printNode(Node head) {
        while(head != null) {
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println();
    }
}
