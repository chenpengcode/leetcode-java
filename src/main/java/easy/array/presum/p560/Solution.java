package main.java.easy.array.presum.p560;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/28
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int s = 0;
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (preSum[j] - preSum[i] == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int subarraySum_2(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}