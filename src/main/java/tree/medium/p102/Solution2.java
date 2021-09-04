package tree.medium.p102;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/4
 */
public class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
