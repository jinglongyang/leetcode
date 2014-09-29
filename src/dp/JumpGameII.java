package dp;

/**
 * https://oj.leetcode.com/problems/jump-game-ii/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
    public int greed(int[] A) {
        int length = A == null ? 0 : A.length;
        int current = 0, next = 0, step = 0;
        for (int i = 0; i < length; ) {
            if (current >= length - 1)
                break;
            while (i <= current) {
                next = Math.max(next, A[i] + i);
                i++;
            }
            current = next;
            step++;
        }
        return step;
    }

    /**
     * DP solution, Time Limit Exceeded for large array size
     *
     * @param A
     * @return
     */
    public int dp(int[] A) {
        int length = A == null ? 0 : A.length;
        if (length < 2) return 1;
        int[] steps = new int[length];
        for (int i = 1; i < length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] >= i - j && min > steps[j] + 1) {
                    min = steps[j] + 1;
                }
            }
            if (min != Integer.MAX_VALUE) {
                steps[i] = min;
            }
        }
        return steps[length - 1];
    }
}
