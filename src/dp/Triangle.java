package dp;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        int size = triangle == null ? 0 : triangle.size();

        int[] dp = new int[triangle.get(size - 1).size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            ArrayList<Integer> level = triangle.get(i);
            for (int j = level.size() - 1; j >= 0; j--) {
                if (j == level.size() - 1) {
                    dp[j] = dp[j - 1] + level.get(j);
                } else if (j == 0) {
                    dp[j] = dp[j] + level.get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + level.get(j);
                }
                if (i == size - 1) {
                    min = Math.min(min, dp[j]);
                }
            }
        }
        return 1 == size ? dp[0] : min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> level1 = new ArrayList<>();
        level1.add(-1);

        ArrayList<Integer> level2 = new ArrayList<>();
        level2.add(2);
        level2.add(3);

        ArrayList<Integer> level3 = new ArrayList<>();
        level3.add(1);
        level3.add(-1);
        level3.add(-3);

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        triangle.add(level1);
        triangle.add(level2);
        triangle.add(level3);
        System.out.println(new Triangle().minimumTotal(triangle));
    }
}
