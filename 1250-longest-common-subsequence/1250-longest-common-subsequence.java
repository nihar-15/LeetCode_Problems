class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        return func(text1 , text2 ,m-1 , n-1 , dp);
    }
    int func(String text1 , String text2 , int i , int j , int dp[][] ){
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j] ;
        }
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + func(text1 , text2, i-1 , j-1 , dp);
        }
        return dp[i][j] =  0 + Math.max(func(text1 , text2, i-1 , j , dp)  , func(text1 , text2, i, j-1 , dp));
    }
}