package math;

/**
 * Created by jinglongyang on 1/28/15.
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(1808548329));
    }

    public int trailingZeroes(int n) {
        if (n < 4) {
            return 0;
        }
        int count = 0;
        long i = 5;
        for (i = 5; n/i >= 1; i *= 5) {
            count += (n / i);
        }
        System.out.println(i);
        return count;
    }

}
