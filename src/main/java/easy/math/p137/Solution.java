package main.java.easy.math.p137;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/19
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int once = 0, twice = 0;
        for (int x : nums) {
            once = ~twice & (once ^ x);
            twice = ~once & (twice ^ x);
        }
        return once;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
    }
}
