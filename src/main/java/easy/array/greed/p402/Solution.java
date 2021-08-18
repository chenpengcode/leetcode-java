package main.java.easy.array.greed.p402;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/2
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                --k;
            }
            stack.addLast(digit);
        }
        while (k > 0) {
            stack.pollLast();
            --k;
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits(num, k));
    }
}
