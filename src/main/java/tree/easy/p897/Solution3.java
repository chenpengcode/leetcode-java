package tree.easy.p897;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/7
 */
public class Solution3 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode();
        TreeNode cur = node;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            cur.right = root;
            cur = root;
            root.left = null;
            root = root.right;
        }
        return node.right;
    }
}
