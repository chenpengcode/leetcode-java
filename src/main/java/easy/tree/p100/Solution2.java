package easy.tree.p100;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/8/28
 */
public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(p);
        stack.addLast(q);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pollLast();
            TreeNode node2 = stack.pollLast();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            stack.addLast(node1.left);
            stack.addLast(node2.left);
            stack.addLast(node1.right);
            stack.addLast(node2.right);
        }
        return true;
    }
}
