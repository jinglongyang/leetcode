package array;

/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 * <p/>
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int l = strs == null ? 0 : strs.length;
        if (l == 0 || strs[0] == null) return "";
        String res = strs[0];
        for (int i = 0; i < res.length(); i++) {
            for (int j = 1; j < l; j++) {
                if (strs[j] == null || i >= strs[j].length() || res.charAt(i) != strs[j].charAt(i)) {
                    return res.substring(0, i);
                }
            }
        }
        return res;
    }
}
