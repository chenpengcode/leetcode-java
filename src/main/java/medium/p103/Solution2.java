package medium.p103;

import tree.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/8/25
 */
class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        boolean isLeft = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (isLeft) deque.offerLast(node.val);
                else deque.offerFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            isLeft = !isLeft;
            ans.add(new ArrayList<>(deque));
        }
        return ans;
    }
}