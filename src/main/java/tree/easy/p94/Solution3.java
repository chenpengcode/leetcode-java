package tree.easy.p94;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/27
 */
public class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root, p;
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                } else {
                    ans.add(cur.val);
                    cur = cur.right;
                    p.right = null;
                }
            }
        }
        return ans;
    }
}
