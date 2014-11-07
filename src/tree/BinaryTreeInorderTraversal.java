package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * <pre>
 * 1
 *  \
 *   2
 *   /
 *   3
 * </pre>
 * return [1,3,2].
 * <p/>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null) {
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

        TreeNode(int val) {
            this.val = val;
        }
    }
}
