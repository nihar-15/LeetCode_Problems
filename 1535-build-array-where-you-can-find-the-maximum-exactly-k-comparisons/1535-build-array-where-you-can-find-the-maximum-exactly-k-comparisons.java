class Solution {
    static int MOD = 1000000007;;
    int dp[][][] = new int[101][101][101];
    int N  , M , K;
    public int numOfArrays(int n, int m, int k) {
        N = n ;
        M = m ;
        K = k ;
        for(int d[][] : dp){
            for(int a[] : d){
                   Arrays.fill(a , -1);
            }
       
        }
        return func(0 ,  0 , 0) % MOD;
    }
     private int func(int idx , int searchCost,  int maximum ){
        if(idx == N){
            if(searchCost == K){
                return 1;
            }
            return 0;
        } 
        if(dp[idx][maximum][searchCost]  != -1){
            return dp[idx][maximum][searchCost] ;
        }
        int result = 0 ;
       for (int i = 1; i <= M; i++) {
            if (i > maximum) {
                result = (result + func(idx + 1, searchCost + 1, i)) % MOD;
            } else {
                result = (result + func(idx + 1, searchCost, maximum)) % MOD;
            }
        }
        return dp[idx][maximum][searchCost] = result % MOD;
     }
}