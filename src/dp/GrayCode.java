package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/gray-code/
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <pre>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * </pre>
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        res.addAll(grayCode(n - 1));
        int high = 1 << (n - 1);
        int size = res.size();
        for (int i = size - 1; i >= 0; i--) {
            res.add(high + res.get(i));
        }
        return res;
    }
}
