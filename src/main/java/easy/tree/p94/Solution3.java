package easy.tree.p94;

import main.java.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/27
 */
public class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        TreeNode p = null;
        while (root != null) {
            if (root.left != null) {
                p = root.left;
                while (p.right != null && p.right != root) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = root;
                    root = root.left;
                } else {
                    inorderList.add(root.val);
                    p.right = null;
                    root = root.right;
                }
            } else {
                inorderList.add(root.val);
                root = root.right;
            }
        }
        return inorderList;
    }
}
