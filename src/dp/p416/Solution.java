package dp.p416;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/21
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;
        int sum = 0, maxEle = 0;
        for (int x : nums) {
            sum += x;
            maxEle = Math.max(maxEle, x);
        }
        if (sum % 2 == 1) return false;
        if (maxEle > sum / 2) return false;
        int target = sum / 2;
        // dp[i][j] 表示从数组的 [0,i]下标范围内选取若干个正整数，是否存在一种选取方案使得被选取的正整数的和等于 j。
        boolean[][] dp = new boolean[len][target + 1];

        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        }
        return dp[len - 1][target];
    }

    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;
        int sum = 0, maxEle = 0;
        for (int x : nums) {
            sum += x;
            maxEle = Math.max(maxEle, x);
        }
        if (sum % 2 == 1) return false;
        if (maxEle > sum / 2) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
