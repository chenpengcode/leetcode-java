package array.presum.p974;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/28
 */
public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int ans = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : A) {
            pre += num;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int m = (pre % K + K) % K;
            int count = map.getOrDefault(m, 0);
            ans += count;
            map.put(m, count + 1);
        }
        return ans;
    }
}
