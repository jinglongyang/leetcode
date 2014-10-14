package stack;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * <a href="https://github.com/jinglongyang/leetcode/blob/master/src/dp/histogram.png">Histogram</a>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <a href="https://github.com/jinglongyang/leetcode/blob/master/src/dp/histogram_area.png">Histogram Area</a>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] height) {
        int l = height == null ? 0 : height.length;
        if (l == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i <= l; i++) {
            int curt = (i == l) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, h * w);
            }
            stack.push(i);
        }
        return area;
    }
}
