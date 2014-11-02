package tree;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p/>
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * confused what "{1,#,2,3}"
 */
public class RecoverBinarySearchTree {
    private static class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    private TreeNode first, second, pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        tranversal(root);
        swap(first, second);
    }

    private void swap(TreeNode first, TreeNode second) {
        int tmp = second.val;
        second.val = first.val;
        first.val = tmp;
    }

    private void tranversal(TreeNode node) {
        if (node == null) return;

        tranversal(node.left);
        if (first == null && node.val < pre.val) {
            first = pre;
        }
        if (first != null && node.val < pre.val) {
            second = node;
        }
        pre = node;
        tranversal(node.right);
    }
}
