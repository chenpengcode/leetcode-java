package tree.p107;

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

    public List<List<Integer>> levelOrderBottom_bfs(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> deq = new LinkedList<>();
        deq.offer(root);
        while (!deq.isEmpty()) {
            int cnt = deq.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = deq.poll();
                level.add(Objects.requireNonNull(node).val);
                if (node.left != null) {
                    deq.offer(node.left);
                }
                if (node.right != null) {
                    deq.offer(node.right);
                }
            }
            ans.add(0, level);
        }
        return ans;
    }
}
