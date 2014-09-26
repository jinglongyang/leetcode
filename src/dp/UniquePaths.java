package dp;

/**
 * https://oj.leetcode.com/problems/unique-paths/
 * <p/>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p/>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p/>
 * How many possible unique paths are there?
 * <a href="https://github.com/jinglongyang/leetcode/blob/master/src/dp/robot_maze.png">Robot Maze</a>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p/>
 * Note: m and n will be at most 100.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] hash = new int[m][n];
        for (int i = 0; i < n; i++) {
            hash[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            hash[i][0] = 1;
        }
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                hash[x][y] = hash[x - 1][y] + hash[x][y - 1];
            }
        }
        return hash[m - 1][n - 1];
    }
}
