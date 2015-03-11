package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jinglongyang on 12/24/14.
 */
public class MaxTree {
    public static void main(String[] args) {
        int[] nums = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        long time = System.currentTimeMillis();
        System.out.println(new MaxTree().maxTree(nums));
        System.out.println(System.currentTimeMillis() - time);
    }

    public TreeNode maxTree(int[] nums) {
        int len = nums == null ? 0 : nums.length;
        if (len == 0) {
            return null;
        }
        Map<Integer, TreeNode> nodes = new HashMap<>();
        for (int i = 0; i < len; i++) {
            nodes.put(nums[i], new TreeNode(nums[i]));
        }
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        left[0] = -1;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        int[] right = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = -1;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        TreeNode root = null;
        for (int i = 0; i < len; i++) {
            TreeNode node = nodes.get(nums[i]);
            if (left[i] == -1) {
                if (right[i] == -1) {
                    root = node;
                } else {
                    nodes.get(nums[right[i]]).left = node;
                }
            } else {
                if (right[i] == -1 || nums[left[i]] < nums[right[i]]) {
                    nodes.get(nums[left[i]]).right = node;
                } else {
                    nodes.get(nums[right[i]]).left = node;
                }
            }
        }
        return root;
    }

    private TreeNode helper(int[] a, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = getMax(a, left, right);
        TreeNode root = new TreeNode(a[maxIndex]);
        root.left = helper(a, left, maxIndex - 1);
        root.right = helper(a, maxIndex + 1, right);
        return root;
    }

    private int getMax(int[] a, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[maxIndex] < a[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
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
