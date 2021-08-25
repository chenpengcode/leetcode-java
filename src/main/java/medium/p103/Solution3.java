package medium.p103;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/8/25
 */
public class Solution3 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Deque<Integer>> list = new ArrayList<>();
        dfs(root, 0, true, list);
        List<List<Integer>> ans = new ArrayList<>();
        for (Deque<Integer> deque : list) {
            ans.add(new ArrayList<>(deque));
        }
        return ans;
    }

    private void dfs(TreeNode root, int level, boolean isLeft, List<Deque<Integer>> list) {
        if (root == null) return;
        if (list.size() == level) list.add(new LinkedList<>());
        if (isLeft) list.get(level).offerLast(root.val);
        else list.get(level).offerFirst(root.val);
        dfs(root.left, level + 1, !isLeft, list);
        dfs(root.right, level + 1, !isLeft, list);
    }
}
