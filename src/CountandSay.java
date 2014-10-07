/**
 * https://oj.leetcode.com/problems/count-and-say/
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 */
public class CountandSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        StringBuilder result = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0, k = 0;
            while (j < result.length() && k < result.length()) {
                while (k < result.length() && result.charAt(j) == result.charAt(k)) {
                    k++;
                }
                sb.append((k - j)).append(result.charAt(j));
                j = k;
            }
            result = new StringBuilder(sb);
            sb.setLength(0);
        }
        return result.toString();
    }
}
