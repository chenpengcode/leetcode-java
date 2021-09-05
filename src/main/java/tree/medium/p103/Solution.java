package tree.medium.p103;

import tree.TreeNode;
import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/22
 */

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // 树的广度优先遍历一般是使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 标识位，如果为true则表明是从左向右，如果为false则表明是从右向左
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            // 层序遍历一般解法：首先获得该层的节点个数
            int size = queue.size();
            // 使用双端队列，维护顺序
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 如果是要从左向右读，那么添加到队尾
                if (isLeft) {
                    assert node != null;
                    list.addLast(node.val);
                } else { //弱国是要从右向左读，那么添加到对头
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 每次遍历完一层，则更改标识符，表明下次的顺序与本次相反
            isLeft = !isLeft;
            ans.add(new LinkedList<>(list));
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        List<Deque<Integer>> res = new ArrayList<>();
        dfs(root, 0, true, res);
        List<List<Integer>> ans = new ArrayList<>();
        for (Deque<Integer> re : res) {
            ans.add(new LinkedList<>(re));
        }
        return ans;
    }

    private void dfs(TreeNode root, int i, boolean isLeft, List<Deque<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() == i) {
            ans.add(new LinkedList<>());
        }
        if (isLeft) {
            ans.get(i).addLast(root.val);
        } else {
            ans.get(i).addFirst(root.val);
        }
        dfs(root.left, i + 1, !isLeft, ans);
        dfs(root.right, i + 1, !isLeft, ans);
    }

}
