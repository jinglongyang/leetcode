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
    private static class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    private enum Status {
        unvisited, visiting
    }

    private static class TreeNodeWrapper {
        private TreeNode node;
        private Status status;

        TreeNodeWrapper(TreeNode node) {
            this.node = node;
            this.status = Status.unvisited;
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNodeWrapper> stack = new Stack<>();
        stack.push(new TreeNodeWrapper(root));
        while (!stack.isEmpty()) {
            TreeNodeWrapper wrapper = stack.peek();
            TreeNode node = wrapper.node;
            if (wrapper.status == Status.unvisited && node.left != null) {
                wrapper.status = Status.visiting;
                stack.push(new TreeNodeWrapper(node.left));
            } else {
                stack.pop();
                res.add(node.val);
                if (node.right != null) {
                    stack.push(new TreeNodeWrapper(node.right));
                }
            }
        }
        return res;
    }
}
