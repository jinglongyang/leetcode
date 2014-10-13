import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/plus-one/
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int l = digits == null ? 0 : digits.length;
        if (l == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int carry = 1, j = l - 1;
        while (j >= 0) {
            int tmp = digits[j] + carry;
            carry = tmp / 10;
            list.add(0, tmp % 10);
            j--;
        }
        if (carry > 0) {
            list.add(0, carry);
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int value : list) {
            res[index++] = value;
        }
        return res;
    }
}
