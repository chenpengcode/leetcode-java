package easy.array.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 使用一个map来存储数组中的值与下标
 * @Author CHENPENG
 * @Date 2021/8/18
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
