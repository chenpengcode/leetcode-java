package search.p34;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/1
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
       int left = binarySearch(nums, target, true);
       int right = binarySearch(nums, target, false) - 1;
       if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
           return new int[]{left, right};
       }
       return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int leftIdx = left, rightIdx = right + 1;
        if (leftIdx > nums.length - 1 || nums[leftIdx] != target) {
            return new int[]{-1, -1};
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        rightIdx = left - 1;
        if (rightIdx < nums.length && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }
}
