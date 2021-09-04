package tree.easy.p145;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/3
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            assert root != null;
            if (root.right == null || root.right == pre) {
                ans.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.addLast(root);
                root = root.right;
            }
        }
        return ans;
    }
}
