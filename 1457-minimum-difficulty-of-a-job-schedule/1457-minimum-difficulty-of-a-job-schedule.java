class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length){
            return -1;
        }
        int dp[][] = new int[jobDifficulty.length+1][d+1];
        for(int a[] : dp){
            Arrays.fill(a , -1);
        }
        return func(jobDifficulty ,  0 , d , dp);
    }
    int func(int jobDifficulty[] , int idx , int d , int dp[][]){
        if( d == 1){
            int maxDiff = jobDifficulty[idx];
            for(int i = idx+ 1 ; i < jobDifficulty.length; i++){
            maxDiff = Math.max(jobDifficulty[i] , maxDiff);
            }
            return dp[idx][d] = maxDiff ;
        }
        int maxD = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE; 
        if(dp[idx][d] != -1){
            return dp[idx][d];
        }
        for(int i = idx ; i<= jobDifficulty.length - d; i ++){
            maxD = Math.max(maxD , jobDifficulty[i]);
            int r = maxD + func(jobDifficulty , i+1 , d-1 , dp);
            result = Math.min(result , r); 

        }
      return dp[idx][d] = result ;
    }
    }
