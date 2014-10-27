package dp;

/**
 * https://oj.leetcode.com/problems/edit-distance/
 * Given two words word1 and word2,
 * find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m1 = word1 == null ? 0 : word1.length(), m2 = word2 == null ? 0 : word2.length();
        int[][] dp = new int[m1 + 1][m2 + 1];
        for (int i = 0; i <= m1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m1; i++) {
            for (int j = 1; j <= m2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //replace dp[i - 1][j - 1]
                    //insert dp[i - 1][j]
                    //delete dp[i][j-1]
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m1][m2];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("a", "b"));
    }
}
