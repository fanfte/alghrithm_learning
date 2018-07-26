package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/18
 **/
public class DeleteNode013 {

    public static void main(String[] args) {

    }

    public ListNode deleteListNode(ListNode head, ListNode toBeDeleted) {
        if(head == null || toBeDeleted == null) {
            return null;
        }
        // 删除的是头节点
        if(head == toBeDeleted) {
            return head.next;
        }
        // 删除的是最后一个节点
        if(toBeDeleted.next == null) {
            ListNode temp = head;
            while(temp.next != toBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            //删除的不是最后一个节点
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
        }
        return head;
    }
}
