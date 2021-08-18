package main.java.easy.backtrack.p46;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/11
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        List<Integer> array = new ArrayList<>();
        dfs(nums, 0, array, ans);
        return ans;
    }

    private void dfs(int[] nums, int idx, List<Integer> array, List<List<Integer>> ans) {
        if (array.size() == nums.length) {
            ans.add(new ArrayList<>(array));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

        }
    }


}
