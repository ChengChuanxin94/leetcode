package com.qdu.leetcode.tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/20
 */
public class TreeLevelTraverse {
    public static void main(String[] args) {
        TreeLevelTraverse treeLevelTraverse = new TreeLevelTraverse();
        Integer[] array = {1, 2, 3, 4, null, null, 5, 6, 7, null, null, null, null, 8, 9};
        TreeNode root = TreeNode.buildTree(array, 0);
        treeLevelTraverse.levelOrderBottom(root);
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        Collections.reverse(list);
        return list;
    }

    public void dfs(TreeNode tree, List<List<Integer>> list, int index) {
        if (tree == null) {
            return;
        }
        if (list.size() - 1 < index) {
            list.add(new ArrayList<>());
        }
        List<Integer> integers = list.get(index);
        integers.add(tree.val);
        dfs(tree.left, list, index + 1);
        dfs(tree.right, list, index + 1);

    }
}
