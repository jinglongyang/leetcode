package math;

import java.math.BigInteger;

/**
 * Created by jinglongyang on 1/27/15.
 */
public class IsFibo {
    public static void main(String[] args) {
        for (long i = 3; i < 9; i++) {
            BigInteger n = BigInteger.valueOf(i);
            BigInteger square = n.multiply(n).multiply(BigInteger.valueOf(5));
            if (isPerfectSquare(square.add(BigInteger.valueOf(4))) || isPerfectSquare(square.subtract(BigInteger.valueOf(4)))) {
                System.out.println(i + " IsFibo");
            } else {
                System.out.println(i + " IsNotFibo");
            }
        }
        System.out.println(getMaxDecentNumber(3));
    }

    private static boolean isPerfectSquare(BigInteger a) {
        BigInteger left = BigInteger.ONE, right = a.divide(BigInteger.valueOf(2));
        while (right.subtract(left).compareTo(BigInteger.ONE) > 0) {
            BigInteger mid = left.add(right).divide(BigInteger.valueOf(2));

            BigInteger square = mid.multiply(mid);
            int comparison = square.compareTo(a);
            if (comparison == 0) {
                return true;
            } else if (comparison > 0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left.multiply(left).compareTo(a) == 0 || right.multiply(right).compareTo(a) == 0;
    }

    private static String getMaxDecentNumber(int num) {
        if (num < 3) {
            return "-1";
        }
        int tmp = num;
        while (tmp >= 0) {
            if (tmp % 3 == 0 && (num - tmp) % 5 == 0) {
                int countOfFive = tmp;
                int countOfThree = num - tmp;
                StringBuilder res = new StringBuilder();
                while (countOfFive > 0) {
                    res.append(5);
                    countOfFive--;
                }
                while (countOfThree > 0) {
                    res.append(3);
                    countOfThree--;
                }
                return res.toString();
            }
            tmp--;
        }
        return "-1";
    }
}
