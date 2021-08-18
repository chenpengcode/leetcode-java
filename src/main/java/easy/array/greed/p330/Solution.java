package main.java.easy.array.greed.p330;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/29
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int ans = 0;
        long x = 1;
        int len = nums.length, index = 0;
        while (x <= n) {
            if (index < len && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new Solution();
        System.out.println(solution.minPatches(nums, 20));
    }
}
