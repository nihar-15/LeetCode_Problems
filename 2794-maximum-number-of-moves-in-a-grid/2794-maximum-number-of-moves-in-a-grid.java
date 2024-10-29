class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] memo = new int[m][n];
        
     
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dfs(grid, i, 0, m, n, memo));
        }
        
        return ans;
    }
    
    private int dfs(int[][] grid, int i, int j, int m, int n, int[][] memo) {
        if (i < 0 || i >= m || j >= n) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        
        int maxSteps = 0;
        
        if (i - 1 >= 0 && j + 1 < n && grid[i][j] < grid[i - 1][j + 1]) {
            maxSteps = Math.max(maxSteps, 1 + dfs(grid, i - 1, j + 1, m, n, memo));
        }
        if (j + 1 < n && grid[i][j] < grid[i][j + 1]) {
            maxSteps = Math.max(maxSteps, 1 + dfs(grid, i, j + 1, m, n, memo));
        }
        if (i + 1 < m && j + 1 < n && grid[i][j] < grid[i + 1][j + 1]) {
            maxSteps = Math.max(maxSteps, 1 + dfs(grid, i + 1, j + 1, m, n, memo));
        }

      
        return   memo[i][j] = maxSteps;
    }
}
