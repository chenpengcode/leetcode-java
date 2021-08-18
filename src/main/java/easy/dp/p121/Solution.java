package main.java.easy.dp.p121;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/17
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + prices[i] - prices[i - 1], 0);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int curProfit = 0;
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            curProfit = Math.max(curProfit + prices[i] - prices[i - 1], 0);
            maxProfit = Math.max(curProfit, maxProfit);
        }
        return maxProfit;
    }
}