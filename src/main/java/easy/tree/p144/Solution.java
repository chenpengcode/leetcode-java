package easy.tree.p144;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/2
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {return;}
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }
}