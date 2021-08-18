package main.java.easy.array.p119;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/6
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.asList(dp);
    }

    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        System.out.println(solution.getRow(n));
    }
}
