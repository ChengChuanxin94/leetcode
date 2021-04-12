package com.qdu.leetcode.tree;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/20
 */
public class TreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }
}
