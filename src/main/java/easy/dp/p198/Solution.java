package main.java.easy.dp.p198;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/9
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            int tmp = first;
            first = second;
            second = Math.max(second, tmp + nums[i]);
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution solution = new Solution();
        System.out.println(solution.rob2(nums));
    }
}
