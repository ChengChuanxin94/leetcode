package com.qdu.leetcode.tree;
/**
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2020/11/17
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
