package tree.p102;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-19 22:17
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> deq = new LinkedList<>();
        deq.offer(root);

        while (!deq.isEmpty()) {
            int length = deq.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = deq.poll();
                assert node != null;
                level.add(node.val);
                if (node.left != null) {
                    deq.offer(node.left);
                }
                if (node.right != null) {
                    deq.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrder_dfs(TreeNode root) {
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