package tree.easy.p938;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/8
 */
public class Solution3 {
    /**
     * 深度优先遍历的迭代写法
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            // 出栈顺序是有序的
            root = stack.pollLast();
            if (root.val > high) {
                break;
            }
            if (root.val >= low) {
                ans += root.val;
            }
            root = root.right;
        }
        return ans;
    }
}
