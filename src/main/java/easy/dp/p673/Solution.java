package main.java.easy.dp.p673;
import java.util.*;
/**
 * @Description
 * @Author CP
 * @Date 2020/12/12
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLength = 1;
        dp[0] = 1;
        Arrays.fill(count, 1);
        for (int i = 1; i < n; ++i){
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                int diff = nums[i] - nums[j];
                if (diff > 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                ans += count[i];
            }
        }
        return ans;
    }
}
