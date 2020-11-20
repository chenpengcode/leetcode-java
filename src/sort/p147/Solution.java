package sort.p147;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode sortedNode = head;
        ListNode curNode = head.next;
        while (curNode != null) {
            if (sortedNode.val <= curNode.val) {
                sortedNode = sortedNode.next;
            } else {
                ListNode pre = res;
                while (pre.next.val <= curNode.val) {
                    pre = pre.next;
                }
                sortedNode.next = curNode.next;
                curNode.next = pre.next;
                pre.next = curNode;
            }
            curNode = sortedNode.next;
        }
        return res.next;
    }
}
