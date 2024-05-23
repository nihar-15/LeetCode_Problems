class Solution {
    int lps =0  , cur = 0;
    int maxStart=0;
    int maxEnd =0;
    public String longestPalindrome(String s) {
     int maxLength = 1, n = s.length(); 
        if (n == 0) {
            return ""; 
        }
        if (n == 1) {
            return s;
        }
      /*  String ans = s.substring(0, 1); // 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 
                if (isValid(s, i, j) && (j - i + 1 > maxLength)) {
                    ans = s.substring(i, j + 1);
                    maxLength = j - i + 1;
                }
            }
        }


         String rev = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[n][n];
        for(int rows[] :dp){
            Arrays.fill(rows , -1);
        }
        func(s ,rev , n-1 , n-1  , dp);
        System.out.println(lps);
         System.out.println(maxStart);
        return s.substring(maxStart , maxStart+lps);
        */

         if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Even length palindromes
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
       
    

    int  func(String s1 , String s2 , int i , int j , int dp[][]){
       if( i <0 || j <0 ){
        return 0;
       }
       if(dp[i][j] != - 1){
        return dp[i][j];
       }
       if(s1.charAt(i) == s2.charAt(j)){
          int  cur = 1+ func(s1 , s2 , i -1 , j-1 , dp);
           if(cur > lps){
            maxStart = i - cur +1;
            lps =cur; 
           }
           return dp[i][j] = cur;
       }
       
       return dp[i][j] = Math.max( func(s1 , s2 , i-1 , j ,dp) , func(s1 , s2 ,i , j-1, dp));
    }

    boolean isValid(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;

    }
    }