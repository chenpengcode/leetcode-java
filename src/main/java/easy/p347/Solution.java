package main.java.easy.p347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/4
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : map.keySet()) {
            pq.add(map.get(x));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}