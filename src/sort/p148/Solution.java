package sort.p148;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        if (left != null) {
            h.next = left;
        } else {
            h.next = right;
        }
        return res.next;
    }

    public ListNode sortList_2(ListNode head) {
        int cnt = 1;
        int length = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            ++length;
        }

        ListNode res = new ListNode(-1);
        res.next = head;
        while (cnt < length) {
            ListNode pre = res;
            h = res.next;
            while (h != null) {
                ListNode h1 = h;
                int size = cnt;
                while (h != null && size > 0) {
                    h = h.next;
                    --size;
                }
                if (size > 0) {
                    break;
                }
                ListNode h2 = h;
                if (h == null) {
                    break;
                }
                size = cnt;
                while (h != null && size > 0) {
                    h = h.next;
                    --size;
                }
                int c1 = cnt;
                int c2 = cnt - size;
                while (c1 > 0 && c2 > 0) {
                    if (h1.val <= h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        --c1;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        --c2;
                    }
                    pre = pre.next;
                }
                pre.next = c1 > 0 ? h1 : h2;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    --c1;
                    --c2;
                }
                pre.next = h;
            }
            cnt *= 2;
        }
        return res.next;
    }
}