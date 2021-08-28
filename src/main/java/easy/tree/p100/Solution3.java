package easy.tree.p100;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/8/28
 */
public class Solution3 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1.val != node2.val) return false;
            if (node1.left == null ^ node2.left == null) return false;
            if (node1.right == null ^ node2.right == null) return false;
            if (node1.left != null) q1.offer(node1.left);
            if (node1.right != null) q1.offer(node1.right);
            if (node2.left != null) q2.offer(node2.left);
            if (node2.right != null) q2.offer(node2.right);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
