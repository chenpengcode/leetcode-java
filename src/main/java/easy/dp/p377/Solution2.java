package main.java.easy.dp.p377;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/24
 */
public class Solution2 {
    Map<Integer, Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        return backtrack(nums, target);
    }

    private int backtrack(int[] nums, int remains) {
        if (remains == 0) return 0;

        if (map.containsKey(remains)) return map.get(remains);

        int res = 0;
        for (int num : nums) {
            if (remains >= num) {
                res += backtrack(nums, remains - num);
            }
        }
        map.put(remains, res);
        return res;
    }
}
