package greed.p621;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/5
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxExec = 0;
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxExec = Math.max(maxExec, map.get(c));
        }

        int maxCount = 0;
        for (int count : map.values()) {
            if (count == maxExec) {
                ++maxCount;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        Solution solution = new Solution();
        int res = solution.leastInterval(tasks, n);
        System.out.println(res);
    }
}