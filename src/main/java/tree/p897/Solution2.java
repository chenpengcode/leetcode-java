package main.java.easy.tree.p897;

import main.java.easy.tree.TreeNode;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/25
 */
public class Solution2 {
    private TreeNode res;

    public TreeNode increasingBST (TreeNode root) {
        TreeNode p = new TreeNode(-1);
        res = p;
        inorder(root);
        return p.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        res.right = root;
        root.left = null;
        res = root;

        inorder(root.right);
    }

}
