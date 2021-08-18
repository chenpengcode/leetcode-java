package main.java.easy.tree.p94;

import main.java.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/27
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            assert root != null;
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
