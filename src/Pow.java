/**
 * https://oj.leetcode.com/problems/powx-n/
 * <p/>
 * Implement pow(x, n).
 */
public class Pow {
    public double pow(double x, int n) {
        if (n < 0) return 1.0 / power(x, -n);

        return power(x, n);
    }

    private double power(double x, int n) {
        if (n == 0) return 1;
        double tmp = power(x, n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        } else {
            return tmp * tmp * x;
        }
    }
}
