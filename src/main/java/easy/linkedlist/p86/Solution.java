package main.java.easy.linkedlist.p86;

import main.java.easy.linkedlist.p234.ListNode;

/**
 * @Description
 * @Author CP
 * @Date 2021/1/3
 */

//Definition for singly-linked list.

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);
        ListNode left = leftHead, right = rightHead;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = rightHead.next;
        right.next = null;
        return leftHead.next;
    }
}
