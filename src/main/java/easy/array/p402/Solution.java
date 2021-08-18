package main.java.easy.array.p402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-15 17:29
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits(num, k));
    }
}
