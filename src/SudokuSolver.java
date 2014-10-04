/**
 * https://oj.leetcode.com/problems/sudoku-solver/
 * <p/>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int index) {
        if (index > 80) return true;
        int row = index / 9, col = index % 9;
        if (board[row][col] != '.') {
            return dfs(board, index + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (dfs(board, index + 1)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            int row_s = 3 * (row / 3) + i / 3;
            int column_s = 3 * (col / 3) + i % 3;
            if (board[row_s][column_s] == c)
                return false;
        }
        return true;
    }
}
