package stack;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/maximal-rectangle/
 * <p/>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix == null ? 0 : matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[] height = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }

    private int largestRectangleArea(int[] height) {
        int l = height == null ? 0 : height.length;
        if (l == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = height[0];
        for (int i = 1; i <= l; i++) {
            int cur = i == l ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
