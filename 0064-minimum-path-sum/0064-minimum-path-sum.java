class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        return func( grid , 0, 0 , m ,n , dp);
    }
    int func(int grid[][] , int i , int j , int m , int n , int dp[][]){

        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }
        if(i == m-1 && j == n-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1 ){
            return dp[i][j];
        }
        int down = func(grid , i+1 , j , m , n , dp);
        int right = func(grid , i , j+1 , m , n, dp);

        int ans = grid[i][j] + Math.min(down , right);
        return dp[i][j] = ans;
    }
}