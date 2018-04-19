package com.fanfte.algorithm.list;

public class PrintCommonPart {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);

        Node node2 = new Node(2);
        node2.next = new Node(3);

        new PrintCommonPart().printCommonPart(node1, node2);
    }

    public Node reverse(Node head) {
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

    public static class Node {
        private int value;

        public Node(int value) {
            this.value = value;
        }
        private Node next;
    }

    public void printCommonPart(Node head1, Node head2) {
        while(head1 != null && head2 != null) {
            if(head1.value < head2.value) {
                head1 = head1.next;
            } else if(head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
