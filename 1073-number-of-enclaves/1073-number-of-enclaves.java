class Solution {
    int dr[] = {0, -1, 0, 1};
    int dc[] = {-1, 0, 1, 0};

    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int vis[][] = new int[m][n];

        // Mark all boundary-connected land cells
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 1) {
                dfs(board, i, 0, vis);
            }
            if (board[i][n - 1] == 1) {
                dfs(board, i, n - 1, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 1) {
                dfs(board, 0, i, vis);
            }
            if (board[m - 1][i] == 1) {
                dfs(board, m - 1, i, vis);
            }
        }

        int cnt = 0;
        // Count all land cells that are not marked
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(int[][] board, int r, int c, int[][] vis) {
        vis[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = r + dr[i];
            int newCol = c + dc[i];
            if (isSafe(board, newRow, newCol) && board[newRow][newCol] == 1 && vis[newRow][newCol] == 0) {
                dfs(board, newRow, newCol, vis);
            }
        }
    }

    boolean isSafe(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
