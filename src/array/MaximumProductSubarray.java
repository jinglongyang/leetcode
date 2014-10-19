package array;

/**
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 * <p/>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int maxProduct(int[] A) {
        int l = A == null ? 0 : A.length;
        if (l == 0) return 0;
        int max = A[0], min = A[0];
        int maxRes = max;
        for (int i = 1; i < l; i++) {
            if (A[i] == 0) {
                maxRes = Math.max(0, maxRes);
                max = 1;
                min = 1;
            } else {
                int tmp = max3(max * A[i], min * A[i], A[i]);
                min = min3(max * A[i], min * A[i], A[i]);
                max = tmp;
                maxRes = Math.max(max, maxRes);
            }
        }
        return maxRes;
    }
}
