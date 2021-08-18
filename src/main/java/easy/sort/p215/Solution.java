package main.java.easy.sort.p215;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-17 16:31
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1 ; i--) {
            swap(nums, 0, i);
            -- heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int size) {
        for (int i = size / 2; i >= 0 ; i--) {
            maxHeapify(nums, i, size);
        }
    }
    public void maxHeapify(int[] nums, int i, int heapSize) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, k));
    }
}
