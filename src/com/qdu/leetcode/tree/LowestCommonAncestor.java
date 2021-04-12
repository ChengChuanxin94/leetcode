package com.qdu.leetcode.tree;
/**
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2021/2/5
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode treeNode = new LowestCommonAncestor().lowestCommonAncestor(root, new TreeNode(0), new TreeNode(5));

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;

    }
}
