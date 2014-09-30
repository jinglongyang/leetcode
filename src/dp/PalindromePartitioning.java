package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * <pre>
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * </pre>
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int length = s == null ? 0 : s.length();
        if (length == 0) {
            return res;
        }
        boolean[][] palindromes = new boolean[length + 1][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (isPalindrome(s.substring(i, j))) {
                    palindromes[i][j] = true;
                }
            }
        }
        
        helper(res, new ArrayList<String>(), 0, length, s, palindromes);
        return res;
    }

    private void helper(List<List<String>> res, List<String> path, int start, int length, String s, boolean[][] palindromes) {
        if (start >= length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start + 1; i <= length; i++) {
            if (palindromes[start][i]) {
                path.add(s.substring(start, i));
                helper(res, path, i, length, s, palindromes);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 1) return true;
        int i = 0, j = length - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
