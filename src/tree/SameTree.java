package tree;

/**
 * https://oj.leetcode.com/problems/same-tree/
 * <p/>
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    /**
     * Definition for singly-linked list.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
