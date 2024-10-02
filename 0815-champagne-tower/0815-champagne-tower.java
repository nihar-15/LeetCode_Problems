class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
      double dp[][] = new double[1001][1001];
        for(double d[] : dp){
            Arrays.fill(d , -1);
        }
        return Math.min(1.0 ,func(poured , query_row , query_glass ,dp));
    }
    double func(int poured , int i , int j , double[][] dp){

        if(i < 0 || j < 0 || j > i){
            return 0;
        }
        if(i == 0 && j == 0){
            return poured;
        }
          if(dp[i][j] != -1){
            return dp[i][j];
        } 
        double up_left = (func(poured , i-1 , j-1 , dp) - 1)/ 2.0;
        double up_right = (func(poured , i-1 , j , dp) - 1)/ 2.0;
       if(up_left < 0){
         up_left = 0;
       }
       if(up_right < 0){
        up_right = 0;
       }
       return dp[i][j] = up_left + up_right ;
    }
}