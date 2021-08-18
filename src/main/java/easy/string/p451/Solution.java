package main.java.easy.string.p451;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/23
 */
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for (char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        for (char c : map.keySet()) {
            queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            int cnt = map.get(c);
            for (int i = 0; i < cnt; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        int maxNum = 0;
        for (char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            int cnt = map.get(c);
            maxNum = Math.max(maxNum, cnt);
        }
        List<Character>[] buckets = new List[maxNum + 1];

        for (char c : map.keySet()) {
            int cnt = map.get(c);
            if (buckets[cnt] == null) buckets[cnt] = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                buckets[cnt].add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxNum; i > 0 ; i--) {
            if (buckets[i] == null) continue;
            int size = buckets[i].size();
            for (int j = 0; j < size; j++) {
                sb.append(buckets[i].get(j));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "main/java/easy/tree";
        Solution solution = new Solution();
        System.out.println(solution.frequencySort2(s));
    }
}
