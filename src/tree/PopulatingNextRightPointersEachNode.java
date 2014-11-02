package tree;

/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Given a binary tree
 * <p/>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * <p/>
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * <pre>
 *     1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * </pre>
 * After calling your function, the tree should look like:
 * <pre>
 *     1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 * </pre>
 */
public class PopulatingNextRightPointersEachNode {
    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode tmp = node.left;
            while (node != null) {
                if (node.left != null)
                    node.left.next = node.right;
                if (node.right != null && node.next != null)
                    node.right.next = node.next.left;
                node = node.next;
            }
            node = tmp;
        }
    }
}
