package main.java.easy.tree.p106;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right)
            return null;

        int val = postorder[post_idx];
        TreeNode root = new TreeNode(val);
        int index = idx_map.get(val);
        post_idx--;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        post_idx = postorder.length - 1;
        int idx = 0;
        for (int val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }
}
