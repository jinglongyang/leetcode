package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jinglongyang on 12/26/14.
 */
public class SerializationDeserializationBinaryTree2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        String tmp = new SerializationDeserializationBinaryTree2().serialize(root);
        System.out.println(tmp);
        System.out.println(new SerializationDeserializationBinaryTree2().deserialize(tmp));
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    res.append("#");
                } else {
                    res.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                res.append(",");
            }
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] parts = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        for (String part : parts) {
            queue.offer(buildTreeNode(part));
        }
        TreeNode root = queue.poll();
        Queue<TreeNode> parents = new LinkedList<>();
        parents.offer(root);
        while (!queue.isEmpty()) {
            TreeNode parent = parents.poll();
            parent.left = queue.poll();
            parent.right = queue.poll();
            if (parent.left != null) {
                parents.offer(parent.left);
            }
            if (parent.right != null) {
                parents.offer(parent.right);
            }
        }
        return root;
    }

    private TreeNode buildTreeNode(String part) {
        if ("#".equals(part)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(part));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "val=" + val + '}';
        }
    }
}
