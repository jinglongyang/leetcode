package map;

/**
 * https://oj.leetcode.com/problems/minimum-window-substring/
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
    }

    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0 || S.length() < T.length()) return "";
        int[] needFound = new int[256];
        for (int i = 0; i < T.length(); i++) {
            needFound[T.charAt(i)]++;
        }
        int[] found = new int[256];
        int start = 0, count = 0;
        String minWindows = null;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (needFound[c] == 0) {
                continue;
            }
            found[c]++;
            if (found[c] <= needFound[c]) {
                count++;
            }
            if (count == T.length()) {
                for (int j = start; j < i; j++) {
                    c = S.charAt(j);
                    if (needFound[c] == 0) {
                        start++;
                        continue;
                    }
                    if (found[c] > needFound[c]) {
                        start++;
                        found[c]--;
                        continue;
                    }
                    break;
                }
                if (minWindows == null || i - start + 1 < minWindows.length()) {
                    minWindows = S.substring(start, i + 1);
                }
            }
        }
        if (minWindows == null) return "";
        return minWindows;
    }
}
