package main.java.easy.array.greed.p376;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/12
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int preDiff = nums[1] - nums[0];
        int ans = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                ++ans;
                preDiff = curDiff;
            }
        }
        return ans;
    }
}