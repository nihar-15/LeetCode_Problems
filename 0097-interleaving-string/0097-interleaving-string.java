class Solution {
    public boolean isInterleave(String a, String b, String c) {
         /* int lcsA = lcs(a ,c);
           int lcsB = lcs(b ,c);
            */
            if(a.length() +b.length() != c.length()){
                return false;
            }
            Boolean dp[][] = new Boolean[a.length()+1][b.length()+1];
            return func(a, b, c , 0 , 0, dp);
           // return lcsA+ lcsB == c.length();
	}


   public boolean  func(String s1 , String s2 , String s3 , int i , int j, Boolean dp[][]) {
        if( i == s1.length() && j == s2.length()){
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            boolean f = func(s1 ,s2 ,s3, i+1, j , dp);
            dp[i][j] = f;
            if(f == true){
                return true;
            }
        }
             if(j  < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            boolean f = func(s1 ,s2 ,s3, i, j+1 , dp);
            dp[i][j] = f;
            if(f == true){
                return true;
            }
             }

        dp[i][j] = false;
        return false;
    }
	  public int lcs(String text1 , String text2){
          int n = text1.length();
     int m = text2.length();
     int dp[][] = new int[n][m];
     for(int a[] :dp){
        Arrays.fill(a , -1);
     }
    return  func(text1 , text2 , n-1, m-1, dp);

        }
        int func(String text1 , String text2, int n , int m, int dp[][]){
            if(n <0 || m<0){
                return 0;
            }
            if(dp[n][m] != -1){
                return dp[n][m];
            }
            if(text1.charAt(n) == text2.charAt(m)){
                return dp[n][m] = 1+ func(text1 , text2 , n-1 , m-1 , dp);
            }
            return dp[n][m]= 0 + Math.max(func(text1 , text2 ,n-1 , m ,dp) , func(text1 , text2 , n , m-1 , dp));
        
    }
}