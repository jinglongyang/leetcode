package dp;

/**
 * https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    public int minCut2(String s) {
        int length = s == null ? 0 : s.length();
        if (length == 0)
            return 0;
        int[] dp = new int[length + 1];
        for (int i = 0; i < length; ++i) {
            dp[i] = length - i;
        }
        boolean[][] palindromes = new boolean[length][length];
        for (int i = length - 1; i >= 0; --i) {
            for (int j = i; j < length; ++j) {
                if ((s.charAt(i) == s.charAt(j) && (j - i < 2)) || (s.charAt(i) == s.charAt(j) && palindromes[i + 1][j - 1])) {
                    palindromes[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0] - 1;
    }

    public int minCut(String s) {
        int length = s == null ? 0 : s.length();
        if (length <= 1) return 0;
        int[] dp = new int[length + 1];

        for (int i = 0; i <= length; ++i) {
            dp[i] = i - 1;
        }
        boolean[][] palindromes = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2 || palindromes[i - 1][j + 1]) {
                        palindromes[j][i] = true;
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[length];
    }

    public int minCut3(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i - 1;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("isPalindrome[%d][%d]=%b\n", j, i - 1, isPalindrome[j][i - 1]);
                if (isPalindrome[j][i - 1]) {
                    res[i] = Math.min(res[j] + 1, res[i]);
                }
            }
        }
        return res[s.length()];
    }

    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; i + j < s.length(); i++) {
                isPalindrome[i][i + j] = (isPalindrome[i + 1][i + j - 1]) && (s.charAt(i) == s.charAt(i + j));
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut3("abcccb"));
    }
}
