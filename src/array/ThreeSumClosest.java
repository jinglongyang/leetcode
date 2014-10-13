package array;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/3sum-closest/
 * <p/>
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p/>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int l = num == null ? 0 : num.length;
        if (l < 3) return 0;

        Arrays.sort(num);
        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < l; i++) {
            int left = i + 1;
            int right = l - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                int dif = Math.abs(target - sum);
                if (dif < min) {
                    min = dif;
                    res = sum;
                }
            }
        }
        return res;
    }
}
