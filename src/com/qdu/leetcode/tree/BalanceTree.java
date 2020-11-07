package com.qdu.leetcode.tree;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/21
 */
public class BalanceTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left)
               && isBalanced(root.right)
               && Math.abs(getTreeDepth(root.left) - getTreeDepth(root.right)) <= 1;
    }

    public int getTreeDepth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(getTreeDepth(tree.left), getTreeDepth(tree.right));
    }
}
