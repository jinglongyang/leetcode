package permutation;

import java.util.ArrayList;

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        return helper(n, new ArrayList<Integer>());
    }

    private int helper(int n, ArrayList<Integer> cols) {
        if (cols.size() == n) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(cols, col)) {
                cols.add(col);
                count += helper(n, cols);
                cols.remove(cols.size() - 1);
            }
        }
        return count;
    }

    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            // same column
            if (cols.get(i) == col) {
                return false;
            }
            // left-top to right-bottom
            if (i - cols.get(i) == row - col) {
                return false;
            }
            // right-top to left-bottom
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
}
