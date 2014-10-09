package permutation;

import java.util.ArrayList;

/**
 * https://oj.leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen
 * and an empty space respectively.
 * <p/>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <pre>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * </pre>
 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        helper(n, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int n, ArrayList<Integer> cols, ArrayList<String[]> result) {
        if (cols.size() == n) {
            result.add(drawChessboard(cols));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(cols, col)) {
                cols.add(col);
                helper(n, cols, result);
                cols.remove(cols.size() - 1);
            }
        }
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

    private String[] drawChessboard(ArrayList<Integer> cols) {
        String[] chessboard = new String[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            chessboard[i] = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    chessboard[i] += "Q";
                } else {
                    chessboard[i] += ".";
                }
            }
        }

        return chessboard;
    }
}
