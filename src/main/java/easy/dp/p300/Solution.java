package main.java.easy.dp.p300;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/12
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                if (diff > 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
