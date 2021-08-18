package main.java.easy.dp.p53;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-18 11:08
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int maxSubArray_2(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray_2(nums));
    }
}
