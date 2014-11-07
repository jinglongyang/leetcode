package stack;

/**
 * https://oj.leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <a href="https://github.com/jinglongyang/leetcode/blob/master/src/dp/rainwatertrap.png">Trapping Rain Water</a>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        int l = A == null ? 0 : A.length;
        if (l < 2) return 0;
        int[] left = new int[l];
        int[] right = new int[l];
        for (int i = 0; i < l; i++) {
            left[i] = i == 0 ? A[i] : Math.max(left[i - 1], A[i]);
        }

        for (int i = l - 1; i >= 0; i--) {
            right[i] = (i == l - 1) ? A[i] : Math.max(right[i + 1], A[i]);
        }

        int res = 0;
        for (int i = 1; i < l - 1; i++) {
            int lowerBar = Math.min(left[i - 1], right[i + 1]);
            if (lowerBar > A[i]) {
                res += (lowerBar - A[i]);
            }
        }
        return res;
    }
}
