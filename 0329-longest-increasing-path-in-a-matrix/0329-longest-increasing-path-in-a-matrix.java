import java.util.Arrays;

class Solution {
    int[] dr = {0, -1, 0, 1};
    int[] dc = {-1, 0, 1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }     
        int maxPathLength = 0;
        // Start DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPathLength = Math.max(maxPathLength, dfs(i, j, matrix, dp));
            }
        }
        return maxPathLength;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] dp) {
       
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        
        int maxLength = 1; 
        
        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            if (isSafe(matrix, newRow, newCol) && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(newRow, newCol, matrix, dp));
            }
        }
        
        dp[row][col] = maxLength; 
        return maxLength;
    }

    private boolean isSafe(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
