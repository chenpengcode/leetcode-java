package main.java.easy.dp.p213;

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
        // 只偷头不偷尾，只偷尾不投头，两者取较大值
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    private int helper(int[] nums, int start, int end) {
        int first = 0, second = 0;
        for (int i = start; i <= end; ++i) {
            int tmp = second;
            second = Math.max(second, first + nums[i]);
            first = tmp;
        }
        return second;
    }
}
