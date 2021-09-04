package tree.medium.p102;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-19 22:17
 */

import tree.TreeNode;

import java.util.*;

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
}