package tree;

import java.util.StringTokenizer;

/**
 * Created by jinglongyang on 12/25/14.
 */
public class SerializationDeserializationBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        String tmp = new SerializationDeserializationBinarySearchTree().serialize(root);
        System.out.println(tmp);
        System.out.println(new SerializationDeserializationBinarySearchTree().deserialize(tmp));
    }

    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        res.setLength(res.length() - 1);
        return res.toString();
    }

    private void serialize(TreeNode node, StringBuilder res) {
        if (node == null) {
            return;
        }
        res.append(node.val).append(",");
        serialize(node.left, res);
        serialize(node.right, res);
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
        TreeNode root = buildTree(new StringTokenizer(data, ","));
        return root;
    }

    private TreeNode readBSTHelper(int min, int max, StringTokenizer tokenizer) {
        if (!tokenizer.hasMoreTokens()) {
            return null;
        }
//        TreeNode node = buildTreeNode(tokenizer.nextToken());

//        if (insertVal > min && insertVal < max) {
//            int val = insertVal;
//            p = new BinaryTree(val);
//            if (fin >> insertVal) {
//                readBSTHelper(min, val, insertVal, p -> left, fin);
//                readBSTHelper(val, max, insertVal, p -> right, fin);
//            }
//        }
        return null;
    }

    public TreeNode buildTree(StringTokenizer tokenizer) {
        if (!tokenizer.hasMoreTokens()) {
            return null;
        }
        TreeNode node = buildTreeNode(tokenizer.nextToken());

        node.left = buildTree(tokenizer);
        node.right = buildTree(tokenizer);

        return node;
    }

    private TreeNode buildTreeNode(String part) {
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
