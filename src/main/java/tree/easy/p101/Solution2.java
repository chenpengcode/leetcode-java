package tree.easy.p101;

import tree.TreeNode;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/4
 */
public class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
}
