package tree.medium.p102;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/4
 */
public class Solution3 {
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
