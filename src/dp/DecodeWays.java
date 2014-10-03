package dp;

/**
 * https://oj.leetcode.com/problems/decode-ways/
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <pre>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * </pre>
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int length = s == null ? 0 : s.length();
        if (length == 0 || s.charAt(0) == '0') return 0;
        int[] ways = new int[length];
        ways[0] = 1;
        for (int i = 1; i < length; i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);
            if (cur < '0' || cur > '9' || (cur == '0' && (pre == '0' || pre > '2'))) return 0;
            if (cur == '0') {
                ways[i] = (i - 2 < 0 ? 1 : ways[i - 2]);
            } else if (pre == '0' || pre > '2' || (pre == '2' && cur > '6')) {
                ways[i] = ways[i - 1];
            } else {
                ways[i] = ways[i - 1] + (i - 2 < 0 ? 1 : ways[i - 2]);
            }
        }
        return ways[length - 1];
    }
}
