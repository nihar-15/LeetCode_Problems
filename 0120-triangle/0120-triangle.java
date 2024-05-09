class Solution {
    public int minimumTotal(List<List<Integer>> grid) {
         int col = grid.get(grid.size()-1).size();
        int dp[][] = new int[col][col];
        for(int a[]: dp){
            Arrays.fill(a , -1);
        }
        
        return func(0 ,0 , grid, dp);
    }
    static int func(int row , int col , List<List<Integer>> grid , int dp[][]){
       if(col >= grid.get(row).size()){
           return Integer.MAX_VALUE;
       }
        if(row == grid.size()-1){
            return dp[row][col] = grid.get(row).get(col);
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int a = func(row+1 , col , grid, dp);
        int b = func(row+1 , col+1 , grid, dp);
        
        return dp[row][col] = Math.min(a, b)+grid.get(row).get(col);
    }
}