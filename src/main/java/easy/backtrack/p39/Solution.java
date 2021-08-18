package main.java.easy.backtrack.p39;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/11
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int i) {
        if (i == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(combine);
            return;
        }
        dfs(candidates, target, ans, combine, i + 1);

        if (target - candidates[i] >= 0) {
            combine.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, combine, i);
            combine.remove(combine.size() -1);
        }
    }
}
