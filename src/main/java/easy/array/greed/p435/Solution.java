package main.java.easy.array.greed.p435;

import java.util.Arrays;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/31
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int n = intervals.length;
        int right = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++cnt;
                right = intervals[i][1];
            }
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{3, 4}, {2, 3}, {1, 3}, {1, 2}};
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
