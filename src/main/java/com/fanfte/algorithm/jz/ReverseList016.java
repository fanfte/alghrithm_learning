package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/18
 **/
public class ReverseList016 {
    public static void main(String[] args) {

    }

    public ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
