package tree.medium.p199;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CHENPENG
 * @Date 2021/11/3 15:27
 * @Description
 */
public class Solution3 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(ans, root, 0);
        return ans;
    }

    private void helper(List<Integer> ans, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (ans.size() == depth) {
            ans.add(root.val);
        }
        helper(ans, root.right, depth + 1);
        helper(ans, root.left, depth + 1);
    }
}
