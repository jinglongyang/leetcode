/**
 * https://oj.leetcode.com/problems/divide-two-integers/
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        int sign = 1;
        if (dividend < 0) {
            sign *= -1;
        }
        if (divisor < 0) {
            sign *= -1;
        }
        int res = 0;
        long a = dividend > 0 ? dividend : dividend;
        long b = divisor > 0 ? divisor : -divisor;
        while (a >= b) {
            long t = b;
            for (int i = 1; a >= t; t <<= 1, t <<= 1) {
                a = a - t;
                res += i;
            }
        }
        return sign * res;
    }
}
