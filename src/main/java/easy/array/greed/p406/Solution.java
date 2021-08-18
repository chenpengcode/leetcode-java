package main.java.easy.array.greed.p406;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-16 11:16
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int space = person[1] + 1;
            for (int i = 0; i < n; i++) {
                if (ans[i] == null) {
                    space--;
                    if (space == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int[][] reconstructQueue_2(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(solution.reconstructQueue_2(people)));
    }
}
