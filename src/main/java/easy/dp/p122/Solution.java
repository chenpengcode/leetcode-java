package main.java.easy.dp.p122;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/17
 */
public class Solution {
    public int maxProfitGreed(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfitDPBetter(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }
}
