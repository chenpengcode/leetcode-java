package main.java.easy.math.p260;

import java.util.Arrays;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/19
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,5};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.singleNumber(nums)));
    }
}

