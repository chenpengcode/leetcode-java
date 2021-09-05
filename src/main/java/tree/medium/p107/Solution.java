package tree.medium.p107;

import tree.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/26
 */
public class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root, 0);
        Collections.reverse(ans);
        return ans;
    }

    public void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
