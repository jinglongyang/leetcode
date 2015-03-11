package dp;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/wildcard-matching/
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p/>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    //dynamic programming
    public boolean isMatch3(String s, String p) {
        int n = s == null ? 0 : s.length();
        int m = p == null ? 0 : p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                if (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '?' == p.charAt(j - 1))) {
                    dp[i][j] = true;
                } else if ('*' == p.charAt(j - 1)) {
                    if (dp[i - 1][j - 1]) {
                        for (int k = i - 1; k <= n; k++) dp[k][j] = true;
                        break;
                    } else if (dp[i][j - 1]) {
                        for (int k = i; k <= n; k++) dp[k][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[n][m];
    }

    public boolean isMatch2(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[2][n + 1];
        dp[m % 2][n] = true;
        for (int i = m - 1; i >= 0; i--) {
            Arrays.fill(dp[i % 2], false);
            if (p.charAt(i) == '*') {
                for (int j = n; j >= 0; j--) {
                    if (dp[(i + 1) % 2][j]) {
                        for (; j >= 0; j--) {
                            dp[i % 2][j] = true;
                        }
                    }
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    dp[i % 2][j] = (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') && dp[(i + 1) % 2][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    //greedy
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i = 0;
        int j = 0;
        int star = -1;
        int sp = 0;

        while (i < n) {
            //one * and multiple *, same effect
            while (j < m && p.charAt(j) == '*') {
                star = j++;  //* match 0 character
                sp = i;
            }
            if (j == m || (p.charAt(j) != s.charAt(i) && p.charAt(j) != '?')) {
                if (star < 0)
                    return false;
                else {
                    j = star + 1;
                    i = ++sp;     //* match 1 character
                }
            } else {
                i++;
                j++;
            }
        }
        while (j < m && p.charAt(j) == '*') j++;
        return j == m;
    }

}
