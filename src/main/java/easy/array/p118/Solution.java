package main.java.easy.array.p118;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/6
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        Solution solution = new Solution();
        System.out.println(solution.generate(n));
    }
}