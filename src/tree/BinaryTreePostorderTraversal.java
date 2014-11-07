package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * <pre>
 * 1
 *  \
 *   2
 *  /
 * 3
 * </pre>
 * return [3,2,1].
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, prev = null;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.peek();
                if (node.right == null || node.right == prev) {
                    res.add(node.val);
                    prev = stack.pop();
                } else {
                    current = node.right;
                }
            }
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
