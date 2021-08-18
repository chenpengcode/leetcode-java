package main.java.easy.array.offer03;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/16
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++ i) {
                while (nums[i] != i) {
                    if (nums[i] == nums[nums[i]]) return nums[i];
                    int t = nums[i];
                    nums[i] = nums[t];
                    nums[t] = t;
                }
            }
            return -1;
        }
}
