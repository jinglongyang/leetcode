package math;

import java.util.Arrays;

/**
 * Created by jinglongyang on 2/4/15.
 */
public class MultiplicationNumbers {
    public static void main(String[] args) {
        long[] b = new MultiplicationNumbers().multiplicationNumbers(new int[]{4, 3, 2, 1, 2});
        System.out.println(Arrays.toString(b));
    }

    public long[] multiplicationNumbers(int[] a) {
        if (a == null || a.length < 2) {
            throw new IllegalArgumentException("");
        }
        long[] b = new long[a.length];
        b[a.length - 1] = 1L;
        for (int i = a.length - 2; i >= 0; i--) {
            b[i] = b[i + 1] * a[i + 1];
        }
        long res = 1;
        for (int i = 1; i < a.length; i++) {
            res *= a[i - 1];
            b[i] = res * b[i];
        }
        return b;
    }
}
