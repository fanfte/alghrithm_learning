package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/18
 **/
public class MergeTwoLists017 {

    public static void main(String[] args) {

    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }
        ListNode root = new ListNode(0,null);
        ListNode result = root;
        while(head1 != null || head2 != null) {
            if(head1.value <= head2.value) {
                root.next = head1;
                head1 = head1.next;
            } else {
                root.next = head2;
                head2 = head2.next;
            }
            root = root.next;
        }
        if(head1 != null) {
            root.next = head1;
        }

        if(head2 != null) {
            root.next = head2;
        }
        return result.next;
    }
}
