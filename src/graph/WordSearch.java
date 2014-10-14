package graph;

/**
 * https://oj.leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p/>
 * For example,
 * Given board =
 * <pre>
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * </pre>
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int found, int i, int j, boolean[][] visited) {
        if (found == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(found) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = helper(board, word, found + 1, i - 1, j, visited) || helper(board, word, found + 1, i, j + 1, visited) || helper(board, word, found + 1, i + 1, j, visited) || helper(board, word, found + 1, i, j - 1, visited);
        visited[i][j] = false;
        return res;
    }
}
