package bit;

/**
 * https://oj.leetcode.com/problems/divide-two-integers/
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(2147483647, 1));
    }

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
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        while (a >= b) {
//            long t = b;
//            for (int i = 1; a >= t; i <<= 1, t <<= 1) {
//                a -= t;
//                res += i;
//            }
            int shift = 0;
            long tmp = b;
            while (a >= tmp) {
                shift++;
                tmp = 1 << tmp;
                System.out.println(tmp);
            }
            res += ((shift - 1) << 1);
            a -= ((shift - 1) << b);
        }
        return sign * res;
    }
}
