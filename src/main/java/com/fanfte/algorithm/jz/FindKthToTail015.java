package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/18
 **/
public class FindKthToTail015 {

    public static void main(String[] args) {

    }

    public ListNode findKthToTail(ListNode head, int k) {
        if(head == null || k <= 0) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        for(int i = 0;i < k - 1;i++) {
            if(first.next != null) {
                first = first.next;
            } else {
                return null;
            }
        }

        while(second.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
