package dp;

/**
 * Follow up for "Unique Paths":
 * <p/>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p/>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p/>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <pre>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * </pre>
 * <p/>
 * The total number of unique paths is 2.
 * <p/>
 * Note: m and n will be at most 100.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int hash[][] = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            hash[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            hash[i][0] = 1;
        }
        for (int x = 1; x < row; x++) {
            for (int y = 1; y < col; y++) {
                if (obstacleGrid[x][y] == 0) {
                    hash[x][y] = hash[x - 1][y] + hash[x][y - 1];
                } else {
                    hash[x][y] = 0;
                }
            }
        }
        return hash[row - 1][col - 1];
    }
}
