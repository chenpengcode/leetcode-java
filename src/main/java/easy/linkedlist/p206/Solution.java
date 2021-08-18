package main.java.easy.linkedlist.p206;

import main.java.easy.linkedlist.p234.ListNode;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-19 20:23
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }
        return pre;
    }

    public ListNode reverseListRecu(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
