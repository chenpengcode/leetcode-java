package tree.easy.p938;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/27
 */
public class Solution2 {
    /**
     * 广度优先遍历
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                queue.offer(node.left);
            } else if (node.val < low) {
                queue.offer(node.right);
            } else {
                ans += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return ans;
    }
}
