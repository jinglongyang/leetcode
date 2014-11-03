package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/surrounded-regions/
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * <pre>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * </pre>
 * After running your function, the board should be:
 * <pre>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * </pre>
 *
 * BFS is accepted but DFS is overflow
 */
public class SurroundedRegions {
    private static class Point {
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        int m = board == null ? 0 : board.length;
        if (m == 0) return;
        int n = board[0].length;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            queue.offer(new Point(i, 0));
            bfs(board, queue);

            queue.offer(new Point(i, n - 1));
            bfs(board, queue);
        }
        for (int i = 1; i < n; i++) {
            queue.offer(new Point(0, i));
            bfs(board, queue);

            queue.offer(new Point(m - 1, i));
            bfs(board, queue);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'D') board[i][j] = 'O';
            }
        }
    }

    public void bfs(char[][] board, Queue<Point> queue) {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x < 0 || point.x >= board.length || point.y < 0 || point.y >= board[0].length || board[point.x][point.y] != 'O') {
                continue;
            }
            board[point.x][point.y] = 'D';
            queue.add(new Point(point.x - 1, point.y));
            queue.add(new Point(point.x + 1, point.y));
            queue.add(new Point(point.x, point.y - 1));
            queue.add(new Point(point.x, point.y + 1));
        }
    }


    public void solve2(char[][] board) {
        int m = board == null ? 0 : board.length;
        if (m == 0) return;

        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 1; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'D') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'D';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
