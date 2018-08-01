package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/26
 **/
public class Test26 {

    static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode subling;

        public ComplexListNode() {
        }
    }

    public static void cloneNode(ComplexListNode node) {

        ComplexListNode head = node;
        while(head != null) {
            ComplexListNode newNode = new ComplexListNode();
            newNode.value = head.value;
            newNode.subling = null;
            newNode.next = head.next;

            head.next = newNode;
            head = newNode.next;
        }
    }

    public static void connectSublingNode(ComplexListNode node) {
        ComplexListNode head = node;
        while(head != null) {
            ComplexListNode next = head.next;
            if(head.subling != null) {
                next.subling = head.subling.next;
            }
            head = next.next;
        }
    }

    public static ComplexListNode reconnectNodes(ComplexListNode node) {
        if(node == null) {
            return null;
        }
        ComplexListNode head = node;
        ComplexListNode newHead = node.next;
        ComplexListNode pointer = newHead;
        head.next = pointer.next;
        head = head.next;

        while(head != null) {
            pointer.next = head.next;
            pointer = pointer.next;
            head.next = pointer.next;
            head = pointer.next;
        }
        return newHead;
    }

    public static boolean isSame(ComplexListNode h1, ComplexListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }
        return h1 == null && h2 == null;
    }

    public static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }
    public static ComplexListNode clone(ComplexListNode head) {
        // 如果链表为空就直接返回空
        if (head == null) {
            return null;
        }
        // 先复制结点
        cloneNode(head);
        // 再链接sibling字段
        connectSublingNode(head);
        // 将整个链表拆分，返回复制链表的头结点
        return reconnectNodes(head);
    }

    public static void main(String[] args) {
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;
        head.subling = head.next.next;
        head.next.subling = head.next.next.next.next.next;
        head.next.next.next.subling = head.next;
        ComplexListNode tmp = head;
        printList(head);
        ComplexListNode newHead = clone(head);
        printList(head);
        System.out.println(isSame(head, tmp));
        printList(newHead);
        System.out.println(isSame(head, newHead));
        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        ComplexListNode head2 = new ComplexListNode();
        head2.value = 1;
        head2.next = new ComplexListNode();
        head2.next.value = 2;
        head2.next.next = new ComplexListNode();
        head2.next.next.value = 3;
        head2.next.next.next = new ComplexListNode();
        head2.next.next.next.value = 4;
        head2.next.next.next.next = new ComplexListNode();
        head2.next.next.next.next.value = 5;
        head2.next.subling = head2.next.next.next.next;
        head2.next.next.next.subling = head2.next.subling;
        head2.next.next.subling = head2.next.next;
        System.out.println("\n");
        tmp = head2;
        printList(head2);
        ComplexListNode newHead2 = clone(head2);
        printList(head2);
        System.out.println(isSame(head2, tmp));
        printList(newHead2);
        System.out.println(isSame(head2, newHead2));
        ComplexListNode head3 = new ComplexListNode();
        head3.value = 1;
        System.out.println("\n");
        tmp = head3;
        printList(head3);
        ComplexListNode newHead3 = clone(head3);
        printList(head3);
        System.out.println(isSame(head3, tmp));
        printList(newHead3);
        System.out.println(isSame(head3, newHead3));
        ComplexListNode head4 = clone(null);
        printList(head4);
    }

}
