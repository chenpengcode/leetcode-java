package main.java.easy.array.greed.p84;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/26
 */
public class Solution {
    // 枚举宽
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        // 枚举左边界
        for (int left = 0; left < n; left++) {
            int minHeight = Integer.MAX_VALUE;
            // 枚举右边界
            for (int right = left; right < n; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                ans = Math.max(ans, (right - left + 1) * minHeight);
            }
        }
        return ans;
    }

    // 枚举高
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int ans = 0;
        // 枚举高
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int left = i, right = i;
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                --left;
            }
            while (right + 1 < n && heights[right + 1] >= height) {
                ++right;
            }
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }

    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.pollLast();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.offerLast(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.pollLast();
            }
            right[i] = stack.isEmpty() ? n : stack.peekLast();
            stack.offerLast(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public int largestRectangleArea4(int[] heights) {
        int n = heights.length;
        int[] tmp = new int[n + 2];
        System.arraycopy(heights, 0, tmp, 1, n);

        Deque<Integer> stack = new LinkedList<>();
        int area = 0;
        for (int i = 0; i < n + 2; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peekLast()]) {
                int h = tmp[stack.pollLast()];
                area = Math.max(area, (i - stack.peekLast() - 1) * h);
            }
            stack.offerLast(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea4(heights));
    }
}
