package tree;

/**
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Given a binary tree, flatten it to a linked list in-place.
 * <p/>
 * For example,
 * Given
 * <pre>
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * </pre>
 * The flattened tree should look like:
 * <pre>
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * </pre>
 */
public class FlattenBinaryTreeLinkedList {
    private static class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null) {
            flatten(root.right);
        } else if (root.right == null) {
            root.right = root.left;
            flatten(root.left);
            root.left = null;
        } else {
            TreeNode right = root.right;
            root.right = root.left;
            flatten(root.left);
            root.left = null;
            TreeNode node = root;
            while (node.right != null) {
                node = node.right;
            }
            node.right = right;
            flatten(right);
        }
    }
}
