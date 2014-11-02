package tree;

/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * <p/>
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 * <pre>
 *     1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * </pre>
 * After calling your function, the tree should look like:
 * <pre>
 *     1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 * </pre>
 */
public class PopulatingNextRightPointersEachNodeII {
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
            TreeLinkNode head = null, prev = null;
            while (node != null) {
                if (node.left != null) {
                    if (head == null) {
                        head = node.left;
                        prev = head;
                    } else {
                        prev.next = node.left;
                        prev = prev.next;
                    }
                }
                if (node.right != null) {
                    if (head == null) {
                        head = node.right;
                        prev = head;
                    } else {
                        prev.next = node.right;
                        prev = prev.next;
                    }
                }
                node = node.next;
            }
            node = head;
        }
    }
}
