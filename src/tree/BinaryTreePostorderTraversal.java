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
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private enum Status {
        unvisited, visiting;
    }

    private static class TreeNodeWrapper {
        private TreeNode node;
        private Status status;

        TreeNodeWrapper(TreeNode node) {
            this.node = node;
            status = Status.unvisited;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNodeWrapper> stack = new Stack<>();
        stack.push(new TreeNodeWrapper(root));
        while (!stack.isEmpty()) {
            TreeNodeWrapper wrapper = stack.peek();
            TreeNode node = wrapper.node;
            if (wrapper.status == Status.visiting || (node.left == null && node.right == null)) {
                res.add(node.val);
                stack.pop();
            } else {
                wrapper.status = Status.visiting;
                if (node.right != null) {
                    stack.push(new TreeNodeWrapper(node.right));
                }
                if (node.left != null) {
                    stack.push(new TreeNodeWrapper(node.left));
                }
            }
        }
        return res;
    }
}
