package main.java.easy.tree;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/25
 *
 * Definition for a binary main.java.easy.tree node.
 * **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}