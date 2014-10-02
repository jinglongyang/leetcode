package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break/
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        int length = s == null ? 0 : s.length();
        if (length < 1) return false;
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        System.out.println(new WordBreak().wordBreak("a", set));
    }
}
