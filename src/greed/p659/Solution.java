package greed.p659;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/4
 */
public class Solution {
    public boolean isPossible(int[] nums) {
        // key：子序列结尾的数字；value：最小堆，所有以key解为的子序列的长度
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<>());
            }
            // 如果存在以x-1结尾的子序列，取出最短的子序列，将x加入到该子序列中
            // 此时变为以x解为的子序列，存入到哈希表中
            if (map.containsKey(x - 1)) {
                int preLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(preLength + 1);
            // 如果不存在以x-1结尾的子序列，则x单独为一个子序列，长度为1
            } else {
                map.get(x).offer(1);
            }
        }
        // map中存储的是所有子序列的尾部元素及子序列的长度
        for(int x : map.keySet()) {
            if (map.get(x).poll() < 3) {
                return false;
            }
        }
        return true;
    }

    public boolean isPossibleGreed(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        // 每个数字的剩余次数即为每个数字在数组中出现的次数
        for (int x : nums) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            // 只有当一个数字的剩余次数大于 0 时，才需要考虑这个数字是否属于某个子序列
            if (count > 0) {
                int preEndCount = endMap.getOrDefault(x - 1, 0);
                // 判断是否存在以 x−1 结尾的子序列
                if (preEndCount > 0) {
                    //  x 被使用了一次
                    countMap.put(x, count - 1);
                    // 子序列的最后一个数字从 x−1 变成了 x
                    endMap.put(x - 1, preEndCount - 1);
                    // 将 x 作为结尾的子序列的数量加 1
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    // 当 x+1 和 x+2 的剩余次数都大于 0 时，可以新建一个长度为 3 的子序列 x,x+1,x+2
                    if (count1 > 0 && count2 > 0) {
                        // 由于这三个数都被使用了一次，因此需要在第一个哈希表中将这三个数的剩余次数分别减 1
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        // 子序列的最后一个数字是 x+2
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
        Solution solution = new Solution();
        System.out.println(solution.isPossible(nums));
    }
}
