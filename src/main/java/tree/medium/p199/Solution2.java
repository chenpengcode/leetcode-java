package tree.medium.p199;

import tree.TreeNode;

import java.util.*;

/**
 * @Author CHENPENG
 * @Date 2021/11/3 11:41
 * @Description
 */
public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<>();

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (ans.size() == depth) {
                ans.add(node.val);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }
        }
        return ans;
    }
}
