package tree.medium.p199;

import tree.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/27
 */
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> deq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        deq.offer(root);
        while (!deq.isEmpty()) {
            int len = deq.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deq.poll();
                assert node != null;
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
}
