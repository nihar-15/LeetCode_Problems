class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];
        for(int [][]d: dp){
            for(int a[] : d){
            Arrays.fill( a , -1);
        }
        }
        return func(prices , 0 , 1, 2 , dp);
    }
     int func(int prices[] , int day , int canBuy , int transactions , int dp[][][]){
        if(day >= prices.length || transactions == 0){
            return 0;
        }
        if(dp[day][canBuy][transactions] != -1){
            return dp[day][canBuy][transactions] ;
        }
        if(canBuy == 1){
            return dp[day][canBuy][transactions] = Math.max(-prices[day] + func(prices , day+1 , 0,transactions , dp) , func(prices, day+1, 1, transactions, dp));
        }else{
            return  dp[day][canBuy][transactions]  = Math.max(prices[day] + func(prices , day+1 , 1 , transactions-1 , dp) , func(prices, day+1 , 0 , transactions , dp));
        }
    }
}