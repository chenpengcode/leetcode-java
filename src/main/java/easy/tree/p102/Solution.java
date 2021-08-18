package main.java.easy.tree.p102;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-19 22:17
 */

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

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        nodeStack.addLast(root);
        depthStack.addLast(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pollLast();
            int level = depthStack.pollLast();
            if (ans.size() == level) {
                ans.add(new ArrayList<>());
            }
            ans.get(level).add(node.val);
            if (node.right != null) {
                nodeStack.addLast(node.right);
                depthStack.addLast(level + 1);
            }
            if (node.left != null) {
                nodeStack.addLast(node.left);
                depthStack.addLast(level + 1);
            }
        }
        return ans;
    }
}