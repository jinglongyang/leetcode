package tree;

/**
 * Created by jinglongyang on 12/23/14.
 */
public class RemoveNodeBinarySearchTree {
    private TreeNode parent;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        new RemoveNodeBinarySearchTree().removeNode(root, 3);
    }

    /**
     * @param root:  The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode node = findNode(root, value);
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            TreeNode successor = findAndRemoveSuccessor(node);
            node.val = successor.val;
        } else {
            TreeNode successor = node.left;
            node.left = null;
            if (parent == null) {
                return successor;
            } else if (parent.right == node) {
                parent.right = successor;
            } else {
                parent.left = successor;
            }
        }
        return root;
    }

    private TreeNode findNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        parent = root;
        if (root.val < value) {
            return findNode(root.right, value);
        }
        return findNode(root.left, value);
    }

    private TreeNode findAndRemoveSuccessor(TreeNode node) {
        TreeNode cur = node.right;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.left == null) {
                break;
            }
            parent = cur;
            cur = cur.left;
        }
        if (parent != null) {
            parent.left = null;
        } else {
            node.right = cur.right;
        }
        return cur;
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
