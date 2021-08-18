package main.java.easy.sort.p215;

import java.util.Random;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-17 17:05
 */
public class Solution2 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[index];
        }
        return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
    }

    public int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + 1;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int x = nums[right], i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= x){
                swap(nums, ++ i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        Solution2 solution = new Solution2();
        System.out.println(solution.findKthLargest(nums, k));
    }
}
