class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n =cost.length;
          int dp[] = new int[n+1];
        Arrays.fill(dp , -1);

        
        return Math.min(fun(cost ,0,n ,dp) , fun(cost , 1 ,n ,dp));
    }
    int fun(int cost[] ,int i , int n ,int dp[]){
        if(i>=n){
            return  0;
        }
        if(i==n-1){
            return cost[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int one = cost[i]+ fun(cost ,i+1,n,dp);
        int two = cost[i]+ fun(cost ,i+2,n,dp);
        return dp[i]= Math.min(one ,two);
    }
}