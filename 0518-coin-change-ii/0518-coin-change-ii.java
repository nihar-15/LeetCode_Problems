class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[amount+1][coins.length+1];
        for(int d[]: dp){
            Arrays.fill(d , -1);
        }
         return func(coins , 0 , amount, dp);
    }
    int func(int coins[] , int idx , int amount , int dp[][]){
        if(idx >= coins.length){
            return 0 ;
        }
        if(amount == 0){
            return 1;
        }
        if(dp[amount][idx] != -1 ){
            return dp[amount][idx];
        }
        if(coins[idx] > amount){
            return func(coins, idx+1 , amount ,dp);
        }
        int take = func(coins , idx, amount - coins[idx] ,dp);
        int notTake = func(coins , idx+1 , amount, dp);

        return dp[amount][idx]= take + notTake;
    }
}