/**
 * https://oj.leetcode.com/problems/valid-sudoku/
 * Determine if a Sudoku is valid, according to: <a href="http://sudoku.com.au/TheRules.aspx">Sudoku Puzzles - The Rules</a>.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * <p/>
 * 解题思路：想象sudoku格里的数字，就把以这个数字为行下标，列下标或block下标的地方,标记为true，如果对应的格子里已经是true了，表明这个数字重复了，
 * 那么这个sudoku就不是合法的了，board[0][0]='5'，那么就把rows[0][4]=true,cols[0][4]=true,blocks[0][4]=true
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int c = board[i][j] - '1';
                if (rows[i][c] || cols[j][c] || blocks[i - i % 3 + j / 3][c]) {
                    return false;
                }
                rows[i][c] = cols[j][c] = blocks[i - i % 3 + j / 3][c] = true;
            }
        }
        return true;
    }
}
