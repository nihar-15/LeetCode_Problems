class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[][] = new int[n + 1][n + 1];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return func(words , 0  , -1 , dp);
    }
    private int func(String words[] , int curr  , int prev , int[][] dp ){
       if(curr == words.length ){
        return 0;
       }
        int take = 0 ;
        if(dp[curr][prev +1] != -1){
            return dp[curr][prev + 1];
        }
        if(prev == -1 || isPredecessor(words[prev] , words[curr])){
            take = 1+ func(words , curr +1 , curr , dp);
        }
        int notTake = func(words , curr +1 , prev , dp);
        return dp[curr][prev + 1] = Math.max(take , notTake);
    }
    private boolean isPredecessor(String a , String b ){
        int m = a.length();
        int n = b.length();
        int count = 0 , i =0 ,j =0 ; 
        if(m >= n || n - m != 1){
            return false;
        }
        while(i < m && j < n){
            if(a.charAt(i) == b.charAt(j)){
                i++;
            }
            j++;
        }
        return i == m ;
    }
}