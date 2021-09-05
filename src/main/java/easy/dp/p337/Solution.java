package easy.dp.p337;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/9
 */

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res1 = root.val;
        if (root.left != null) {
            res1 += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            res1 += rob(root.right.left) + rob(root.right.right);
        }

        int res2 = 0;
        res2 += rob(root.left) + rob(root.right);

        return Math.max(res1, res2);
    }

    public int rob2(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int res1 = root.val;
        if (root.left != null) {
            res1 += helper(root.left.left, map) + helper(root.left.right, map);
        }
        if (root.right != null) {
            res1 += helper(root.right.left, map) + helper(root.right.right, map);
        }
        int res2 = 0;
        res2 += helper(root.left, map) + helper(root.right, map);
        int res = Math.max(res1, res2);
        map.put(root, res);
        return res;
    }
}
