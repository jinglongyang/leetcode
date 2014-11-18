package math;

/**
 * https://oj.leetcode.com/problems/multiply-strings/
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        StringBuilder tmp1 = new StringBuilder(num1).reverse();
        StringBuilder tmp2 = new StringBuilder(num2).reverse();
        int l = l1 + l2;
        int[] res = new int[l + 1];
        for (int i = 0; i < l1; i++) {
            int a1 = tmp1.charAt(i) - '0';
            for (int j = 0; j < l2; j++) {
                int a2 = tmp2.charAt(j) - '0';
                res[i + j] += a1 * a2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            int digit = res[i] % 10;
            int carry = res[i] / 10;
            res[i + 1] += carry;
            sb.insert(0, digit);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
