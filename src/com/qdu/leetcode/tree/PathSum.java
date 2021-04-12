package com.qdu.leetcode.tree;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/21
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.buildTree(new Integer[] {-2, null, -3}, 0);
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(tree, -5));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
