class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[2][3][prices.length];
        for(int [][]d: dp){
            for(int a[] : d){
            Arrays.fill( a , -1);
        }
        }
      return func(prices , 0, 1 , 2, dp);
    }
    int func(int prices[] , int day , int canBuy,  int capacity , int dp[][][]){
       if(capacity <=0 || day >= prices.length){
        return 0;
       }
       if(dp[canBuy][capacity][day] != -1 ){
         return dp[canBuy][capacity][day] ;
       }
       if(canBuy == 1 ){
        return dp[canBuy][capacity][day] =  Math.max(-prices[day]+func(prices, day+1, 0 , capacity , dp), func(prices, day+1, 1, capacity ,dp));
       }
       return dp[canBuy][capacity][day] = Math.max( prices[day]+func(prices, day+1, 1, capacity-1 ,dp) , func(prices, day+1 ,0 , capacity ,dp));
    }
}