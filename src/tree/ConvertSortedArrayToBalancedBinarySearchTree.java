package tree;

/**
 * http://leetcode.com/2010/11/convert-sorted-array-into-balanced.html
 */
public class ConvertSortedArrayToBalancedBinarySearchTree {
    private static class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode sortedArrayToBST(int arr[]) {
        if (arr == null || arr.length == 0) return null;
        return sortedArrayToBST(arr, 0, arr.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) return null;
        int middle = start + (end = start) / 2;
        TreeNode node = new TreeNode(arr[middle]);
        node.left = sortedArrayToBST(arr, 0, middle - 1);
        node.right = sortedArrayToBST(arr, middle + 1, end);
        return node;
    }
}
