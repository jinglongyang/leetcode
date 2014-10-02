package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break-ii/
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"]
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<>();
        int length = s == null ? 0 : s.length();
        if (length == 0) return res;
        boolean[] dp = new boolean[length + 1];
        Arrays.fill(dp, true);

        helper(res, new StringBuilder(), 0, length, s, dict, dp);
        return res;
    }

    private void helper(List<String> res, StringBuilder path, int start, int length, String s, Set<String> dict, boolean[] dp) {
        if (start >= length) {
            path.setLength(path.length() - 1);
            res.add(path.toString());
            return;
        }
        for (int i = start + 1; i <= length; i++) {
            String word = s.substring(start, i);
            if (dp[i] && dict.contains(word)) {
                int size = res.size();
                int tmp = path.length();
                path.append(word).append(" ");
                helper(res, path, i, length, s, dict, dp);
                if (size == res.size()) {
                    dp[i] = false;
                }
                path.setLength(tmp);
            }
        }
    }
}
