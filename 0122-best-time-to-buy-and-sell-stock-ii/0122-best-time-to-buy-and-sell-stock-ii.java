class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[2][prices.length];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        return func(prices , 0 , 1 , dp);
    }
    int func(int []prices , int idx , int canBuy , int dp[][]){
        if( idx == prices.length){
            return 0;
        }
        int profit =0  ; 
        if(dp[canBuy][idx] != -1){
            return dp[canBuy][idx];
        }
        if( canBuy == 1){
            profit = Math.max(-prices[idx] + func(prices , idx+1 , 0 , dp) , 0+ func(prices , idx+1 , 1, dp));
        }else{
            profit = Math.max(prices[idx] + func(prices , idx+1 , 1 , dp) , func(prices , idx+1 , 0 , dp));
        }
        return dp[canBuy][idx] = profit;
    }
}