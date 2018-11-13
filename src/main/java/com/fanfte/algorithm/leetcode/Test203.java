package com.fanfte.algorithm.leetcode;

import com.fanfte.algorithm.jz.ListNode;

/**
 * Created by tianen on 2018/11/13
 * Test203 on Leetcode
 * @author fanfte
 * @date 2018/11/13
 **/
public class Test203 {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.value == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if(head == null) {
            return head;
        }
        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.value == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        while(head != null && head.value == val) {
            head = head.next;
        }
        if(head == null) {
            return head;
        }
        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.value == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static ListNode removeElements3(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, null);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null) {
            if(prev.next.value == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,null);
        node.next = new ListNode(2, new ListNode(3, null));
        removeElements3(node, 2);
    }
}
