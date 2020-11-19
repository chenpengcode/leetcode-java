package linkedlist.p234;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode rLeft = head;

        while (fast != null && fast.next != null) {
            rLeft = slow;
            slow = slow.next;
            fast = fast.next.next;
            rLeft.next = pre;
            pre = rLeft;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (rLeft != null) {
            if (rLeft.val != slow.val) {
                return false;
            }
            rLeft = rLeft.next;
            slow = slow.next;
        }
        return true;
    }
}