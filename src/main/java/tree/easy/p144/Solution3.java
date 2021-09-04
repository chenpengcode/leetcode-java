package tree.easy.p144;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/9/2
 */
public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
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
                    ans.add(cur.val);
                    p.right = cur;
                    cur = cur.left;
                } else {
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
