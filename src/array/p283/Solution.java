package array.p283;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-19 1:20
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j == nums.length) {
                    break;
                }
                swap(nums, i, j);
            }
            i++;
            j++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
