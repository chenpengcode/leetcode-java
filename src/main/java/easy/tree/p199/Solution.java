package main.java.easy.tree.p199;

import main.java.easy.tree.p107.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/27
 */
class Solution {
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView_bfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> deq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        deq.offer(root);

        while (!deq.isEmpty()) {
            int len = deq.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deq.poll();
                if (i == len - 1) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    deq.offer(node.left);
                }
                if (node.right != null) {
                    deq.offer(node.right);
                }
            }
        }
        return ans;
    }

    public List<Integer> rightSideView_dfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();
        nodes.addLast(root);
        depths.addLast(0);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollLast();
            int depth = depths.pollLast();
            if (ans.size() == depth) {
                ans.add(node.val);
            }
            if (node.left != null) {
                nodes.addLast(node.left);
                depths.addLast(depth + 1);
            }
            if (node.right != null) {
                nodes.addLast(node.right);
                depths.addLast(depth + 1);
            }
        }
        return ans;
    }

    public List<Integer> rightSideView_dfs2(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(root.val);
        }
        helper(root.right, level + 1);
        helper(root.left, level + 1);
    }
}
