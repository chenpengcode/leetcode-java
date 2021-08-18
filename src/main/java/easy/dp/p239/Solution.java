package main.java.easy.dp.p239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/15
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0) return new int[0];
        int[] ans = new int[length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        ans[0] = deque.peekFirst();
        for (int i = k; i < length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            ans[i - k + 1] = deque.peekFirst();
        }
        return ans;
    }
}
