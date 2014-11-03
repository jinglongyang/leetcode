package tree;

/**
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * <p/>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListBinarySearchTree {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        ListNode[] nodes = new ListNode[1];
        nodes[0] = head;
        return constructBinarySearchTree(nodes, 0, count - 1);
    }

    private TreeNode constructBinarySearchTree(ListNode[] nodes, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode left = constructBinarySearchTree(nodes, start, mid - 1);
        TreeNode root = new TreeNode(nodes[0].val);
        root.left = left;
        nodes[0] = nodes[0].next;
        root.right = constructBinarySearchTree(nodes, mid + 1, end);
        return root;
    }
}
