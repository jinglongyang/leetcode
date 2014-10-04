package dp;

/**
 * https://oj.leetcode.com/problems/distinct-subsequences/
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int l1 = T == null ? 0 : T.length();
        int l2 = S == null ? 0 : S.length();
        if (l1 == 0 || l2 == 0) return 0;
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = dp[i][j - 1];
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[l1][l2];
    }
}
