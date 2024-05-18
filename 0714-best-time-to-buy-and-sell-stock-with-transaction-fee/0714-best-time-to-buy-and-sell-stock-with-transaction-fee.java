class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int d[]: dp){
            Arrays.fill(d , -1);
        }
        return  func(prices ,0 , 1, fee ,dp);
    }
    int func(int prices[] , int day , int canBuy , int fee , int dp[][]){
       if(prices.length == day){
        return 0;
       }
       if(dp[day][canBuy] != -1){
        return dp[day][canBuy];
       }
        if(canBuy == 1){
            return dp[day][canBuy] = Math.max(-prices[day] + func(prices, day+1 , 0 , fee ,dp) , func(prices, day+1 ,1, fee ,dp));
        }
        return dp[day][canBuy] = Math.max( prices[day]+func(prices , day+1 , 1 , fee, dp)-fee , func(prices , day+1 , 0 , fee, dp));
    }

}