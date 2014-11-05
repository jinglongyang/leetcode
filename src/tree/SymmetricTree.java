package tree;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/symmetric-tree/
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree is symmetric:
 * <pre></pre>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * <pre>
 *   1
 *  / \
 * 2   2
 * \   \
 * 3    3
 * </pre>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    /**
     * Definition for singly-linked list.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        List<TreeNode> list = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        list.add(root);
        queue.add(Arrays.asList(root));
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = queue.poll();
            int i = 0, j = nodes.size() - 1;
            while (i < j) {
                TreeNode node1 = nodes.get(i);
                TreeNode node2 = nodes.get(j);
                if ((node1 == null && node2 != null) || (node1 != null && node2 == null) || (node1 != null && node2 != null && node1.val != node2.val)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
