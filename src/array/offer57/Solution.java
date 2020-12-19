package array.offer57;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/17
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        int limit = target / 2;
        for (int i = 1; i <= limit; ++i) {
            for (int j = i;;++j) {
                sum += j;
                if (sum == target) {
                    int[] t = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        t[k - i] = k;
                    }
                    list.add(t);
                    sum = 0;
                    break;
                } else if (sum > target) {
                    sum = 0;
                    break;
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public int[][] findContinuousSequence2(int target) {
        List<int[]> ans = new ArrayList<>();
        int left = 1, right = 2;
        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] res = new int[right - left + 1];
                for (int i = 1; i <= right; i++) {
                    res[i - 1] = i;
                }
                ans.add(res);
                ++left;
            } else if (sum < target) {
                ++right;
            } else {
                ++left;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}