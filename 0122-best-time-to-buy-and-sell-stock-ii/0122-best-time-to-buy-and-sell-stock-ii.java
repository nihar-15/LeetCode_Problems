class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
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
        if(dp[idx][canBuy] != -1){
            return dp[idx][canBuy];
        }
        if( canBuy == 1){
            profit = Math.max(-prices[idx] + func(prices , idx+1 , 0 , dp) , 0+ func(prices , idx+1 , 1, dp));
        }else{
            profit = Math.max(prices[idx] + func(prices , idx+1 , 1 , dp) , func(prices , idx+1 , 0 , dp));
        }
        return dp[idx][canBuy] = profit;
    }
}