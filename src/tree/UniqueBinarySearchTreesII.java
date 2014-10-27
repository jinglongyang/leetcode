package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <pre>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * </pre>
 */
public class UniqueBinarySearchTreesII {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        private TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
        } else if (start == end) {
            res.add(new TreeNode(start));
        } else {
            for (int i = start; i < end; i++) {
                List<TreeNode> leftTree = generateTrees(start, i - 1);
                List<TreeNode> rightTree = generateTrees(i + 1, end);
                for (TreeNode leftNode : leftTree) {
                    for (TreeNode rightNode : rightTree) {
                        TreeNode node = new TreeNode(i);
                        node.left = leftNode;
                        node.right = rightNode;
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }
}
