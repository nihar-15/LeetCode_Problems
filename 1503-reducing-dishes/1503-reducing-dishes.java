class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length ;
        int dp[][] = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        Arrays.sort(satisfaction);
        int ans = func(satisfaction , 0 , 0 , dp);
        if(ans < 0){
            return 0;
        }
        return ans;
    }
    int func(int sat[] , int multiplier , int i , int dp[][]){
        if(i == sat.length){
            return 0;
        }
        if(dp[multiplier][i] != -1){
            return dp[multiplier][i];
        }
        int take = sat[i]*(multiplier +1) + func(sat , multiplier + 1,i+1 , dp);
        int notTake = func(sat , multiplier  , i+1 , dp);

        return  dp[multiplier][i] = Math.max(take , notTake);
    }
}