package tree.medium.p107;

import tree.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/5
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
