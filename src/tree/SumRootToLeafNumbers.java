package tree;

/**
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * <pre>
 *   1
 *  / \
 * 2   3
 * </pre>
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
    /**
     * Definition for singly-linked list.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode node, int pathSum) {
        if (node.left == null && node.right == null) {
            return node.val + pathSum * 10;
        }

        int res = 0;
        int tmp = pathSum * 10 + node.val;
        if (node.left != null)
            res += sumNumbers(node.left, tmp);
        if (node.right != null)
            res += sumNumbers(node.right, tmp);
        return res;
    }
}
