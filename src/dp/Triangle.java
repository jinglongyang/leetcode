package dp;

import java.util.List;

/**
 * https://oj.leetcode.com/problems/triangle/
 * <p/>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p/>
 * For example, given the following triangle
 * <pre>
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * </pre>
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p/>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    //bottom up dp, hash[x][y] means 从x,y走到下面一层的最小sum
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        //define Integer instead of int, because we can use null to know if x,y already calculated
        Integer[][] hash = new Integer[row][col];
        dfs(triangle, row, 0, 0, hash);
        return hash[0][0];
    }

    private int dfs(List<List<Integer>> triangle, int row, int x, int y, Integer[][] hash) {
        if (x == row) return 0;
        if (hash[x][y] != null) return hash[x][y];
        hash[x][y] = Math.min(dfs(triangle, row, x + 1, y, hash), dfs(triangle, row, x + 1, y + 1, hash)) + triangle.get(x).get(y);
        return hash[x][y];
    }
}
