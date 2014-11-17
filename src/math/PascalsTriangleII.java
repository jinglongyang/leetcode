package math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) return res;
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            int size = res.size();
            res.add(res.get(size - 1));
            for (int j = size - 1; j >= 0; j--) {
                if (j > 0) {
                    res.set(j, res.get(j) + res.get(j - 1));
                }
            }
        }
        return res;
    }
}
