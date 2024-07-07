class Solution {
    int dp[] = new int[1001];
    public int numDecodings(String s) {
        int n =  s.length();
        Arrays.fill(dp , -1);
         return func(0 , n , s);
    }
    int func(int i , int n , String s){
         if(dp[i] != -1){
            return dp[i];
        }
        if( i == n){
            return dp[i] = 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
       
        int result = func(i+1 , n , s);
        if(i+1 < n){
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <= '6'){
                result += func(i+2 , n , s);
            }
        }
        return dp[i] = result;
    }
}