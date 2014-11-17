package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle/
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * <pre>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * </pre>
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> pres = res.get(i - 1);
            int size = pres.size();
            List<Integer> cur = new ArrayList<>(size + 1);
            cur.add(pres.get(0));
            for (int j = 1; j < size; j++) {
                cur.add(pres.get(j - 1) + pres.get(j));
            }
            cur.add(pres.get(size - 1));
            res.add(cur);
        }
        return res;
    }
}
