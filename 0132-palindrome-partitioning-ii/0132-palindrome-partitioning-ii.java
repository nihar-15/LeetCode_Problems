class Solution {
    public int minCut(String str) {
          // code here
        Boolean[][] palindrome = new Boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                isPalindrome(str, i, j, palindrome);
            }
        }
        int[] dp = new int[str.length()];
        Arrays.fill(dp, -1);
        return minCutRequired(str, str.length() - 1, dp, palindrome);
    }
    
    private static int minCutRequired(String string, int index, int[] dp, Boolean[][] palindrome) {
        if (index < 0 || palindrome[0][index]) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int cut = string.length() - 1;
        for (int i = index; i >= 0; i--) {
            if (palindrome[i][index]) {
                cut = Math.min(cut, 1 + minCutRequired(string, i - 1, dp, palindrome));
            }
        }
        dp[index] = cut;
        return cut;
    }
    
    private static boolean isPalindrome(String string, int start, int end, Boolean[][] palindrome) {
        if (start > end) {
            return true;
        }
        if (palindrome[start][end] != null) {
            return palindrome[start][end];
        }
        return palindrome[start][end] = string.charAt(start) == string.charAt(end) && 
            isPalindrome(string, start + 1, end - 1, palindrome);
    }
}

/*

// gives tle but good solution. Problem is you are checking palindrome multiple times , instead precompute and store , this avoid a lot of computations 
   int n = str.length();
    int [][]dp = new int[n][n]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1); 
        }
        return func(str, 0, n - 1 , dp);
    }
    
    static int func(String str, int i, int j , int dp[][]) {
       
        if (i >= j || isPalindrome(str, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int mini = Integer.MAX_VALUE; 
        for (int k = i; k < j; k++) {
            int left = func(str, i, k , dp);
            int right = func(str, k + 1, j , dp);
            int cuts = left + right + 1; 
            
            mini = Math.min(mini, cuts);
        }
        
        return dp[i][j] = mini;
    }
 
    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
*/