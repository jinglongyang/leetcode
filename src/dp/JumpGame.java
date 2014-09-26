package dp;

/**
 * https://oj.leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        int length = A == null ? 0 : A.length;
        if (length == 0 || length == 1) return true;
        boolean dp[] = new boolean[length];
        dp[0] = true;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && A[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length - 1];
    }
}
