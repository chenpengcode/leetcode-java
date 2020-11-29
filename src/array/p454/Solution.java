package array.p454;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/29
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : A) {
            for (int i : B) {
                map.put(k + i, map.getOrDefault(k + i, 0) + 1);
            }
        }
        int ans = 0;
        for (int k : C) {
            for (int i : D) {
                if (map.containsKey(-(k + i))) {
                    ans += map.get(-(k + i));
                }
            }
        }
        return ans;
    }
}
