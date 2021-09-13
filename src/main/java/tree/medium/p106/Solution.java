package tree.medium.p106;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int postIdx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode helper(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int val = postorder[postIdx];
        TreeNode root = new TreeNode(val);
        int index = idxMap.get(val);
        postIdx--;
        root.right = helper(index + 1, inRight);
        root.left = helper(inLeft, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        postIdx = postorder.length - 1;
        int idx = 0;
        for (int val : inorder) {
            idxMap.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }
}
