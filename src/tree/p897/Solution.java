package tree.p897;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/25
 */
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        TreeNode p = new TreeNode(-1);
        TreeNode cur = p;
        for (int val: res) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return p.right;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
