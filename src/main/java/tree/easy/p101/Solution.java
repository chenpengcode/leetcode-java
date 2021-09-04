package tree.easy.p101;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> deq = new LinkedList<>();
        deq.offer(root);
        deq.offer(root);
        while (!deq.isEmpty()) {
            TreeNode node1 = deq.poll();
            TreeNode node2 = deq.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            deq.offer(node1.left);
            deq.offer(node2.right);
            deq.offer(node1.right);
            deq.offer(node2.left);
        }
        return true;
    }
}
