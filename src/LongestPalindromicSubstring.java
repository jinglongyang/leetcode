/**
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().truncate("1301 Ave FLR31, WA 98021", 13));
    }

    public String truncate(String str, int k) {
        int len = str == null ? 0 : str.length();
        if (k < 1 || len < k) {
            throw new IllegalArgumentException("");
        }
        if (len == k) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (res.length() >= k) {
                if (isNumber(c)) {
                    replace(res, c);
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    private void replace(StringBuilder res, char c) {
        int i = res.length() - 1;
        while (i >= 0) {
            char tmp = res.charAt(i);
            if (!isNumber(tmp)) {
                res.deleteCharAt(i);
                break;
            }
            i--;
        }
        res.append(c);
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
