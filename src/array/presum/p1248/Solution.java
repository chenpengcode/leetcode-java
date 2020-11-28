package array.presum.p1248;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/28
 */
public class Solution {
       public int numberOfSubarrays1(int[] nums, int k) {
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, 1);
        for (int num : nums) {
            pre += (num & 1);
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int num : nums) {
            odd += num & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        Solution solution = new Solution();
        int res = solution.numberOfSubarrays1(nums, k);
        System.out.println(res);
    }
}
