package math.p264.p136;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/19
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int x : nums) ans ^= x;
        return ans;
    }
}