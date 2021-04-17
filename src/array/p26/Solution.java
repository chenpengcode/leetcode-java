package array.p26;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/18
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        while (right < n) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 2, 3, 4, 4, 5};
        System.out.println(solution.removeDuplicates(nums));
    }
}
