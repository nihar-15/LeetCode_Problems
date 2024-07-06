class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
         if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int dp[][] = new int[m][n];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        return func(obstacleGrid , 0 , 0 , m , n , dp);
    }
    int func(int grid[][] , int i , int j , int m , int n , int dp[][]){
        if(i >= m || j >= n){
            return 0;
        }
        if( i == m-1 && j == n-1){
            return 1;
        }
         if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = 0 , down = 0;
       
        if(i+1 <m && grid[i+1][j] != 1){
            right = func( grid , i+1 , j , m , n , dp);
        }
         if(j+1 < n  && grid[i][j+1] != 1){
            down = func( grid , i , j+1 , m , n , dp);
        }
        return dp[i][j] = right+ down;
    }
}