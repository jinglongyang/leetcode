package dp;

/**
 * https://oj.leetcode.com/problems/minimum-path-sum/
 * <p/>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers
 * along its path.
 * <p/>
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int hash[][] = new int[row][col];
        hash[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            hash[i][0] = hash[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            hash[0][i] = hash[0][i - 1] + grid[0][i];
        }
        for (int x = 1; x < row; x++) {
            for (int y = 1; y < col; y++) {
                hash[x][y] = Math.min(hash[x - 1][y], hash[x][y - 1]) + grid[x][y];
            }
        }
        return hash[row - 1][col - 1];
    }
}
