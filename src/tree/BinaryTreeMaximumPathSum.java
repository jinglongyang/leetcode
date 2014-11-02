package tree;

/**
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * Given a binary tree, find the maximum path sum.
 * <p/>
 * The path may start and end at any node in the tree.
 * <p/>
 * For example:
 * Given the below binary tree,
 * <pre>
 *   1
 *  / \
 * 2   3
 * </pre>
 * Return 6.
 */
public class BinaryTreeMaximumPathSum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) return 0;
        int left = dfs(node.left, res);
        int right = dfs(node.right, res);
        int m = node.val;
        if (left > 0) m += left;
        if (right > 0) m += right;

        if (m > res[0]) res[0] = m;
        return Math.max(node.val, Math.max(left, right) + node.val);
    }
}
