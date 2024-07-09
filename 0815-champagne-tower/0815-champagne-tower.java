class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][] = new double[1001][1001];
        for(double d[] : dp){
            Arrays.fill(d , -1);
        }
        return Math.min(1.0 ,func(poured , query_row , query_glass ,dp));
    }
    double func(int poured , int i , int j  ,double[][] dp){
        if(i < 0 || j > i || j < 0)
            return 0.0;

        if(i == 0 && j == 0){
            return (double)poured;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        } 
      double a = (func(poured ,i-1 , j-1  , dp) -1) /2.0;
      double b = (func(poured  , i-1 , j  , dp) -1) /2.0;
      if(a < 0){
        a = 0.0;
      } 
      if(b < 0){
        b = 0.0 ;
      }

       return dp[i][j] = a + b; 
    }
}