package tree.easy.p144;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/2
 */
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.val);
                stack.offerLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            assert root != null;
            root = root.right;
        }
        return ans;
    }
}
