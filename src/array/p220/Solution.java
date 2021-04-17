package array.p220;

import java.util.TreeSet;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/17
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            // 返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        int t = 0;
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
    }
}