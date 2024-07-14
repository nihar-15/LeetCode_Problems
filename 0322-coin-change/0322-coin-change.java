class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[amount+1][coins.length+1];
        for(int d[] :dp){
            Arrays.fill(d , -1);
        }
        int ans = func(coins , 0 , amount, dp);
        if(ans >= Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    int func(int coins[] , int idx , int amount , int dp[][]){
       
        if(amount == 0){
            return 0;
        }
        if(dp[amount][idx] != -1 ){
            return dp[amount][idx];
        }
         if(idx >= coins.length){
            return Integer.MAX_VALUE;
        }
        int take = Integer.MAX_VALUE;
        // If we can take the current coin
        if (coins[idx] <= amount) {
            int res = func(coins, idx, amount - coins[idx] , dp);
            // If res is not max value, it means we found a solution
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        int notTake = func(coins ,idx+1 , amount, dp);

        return dp[amount][idx] = Math.min(take , notTake);
    }
}