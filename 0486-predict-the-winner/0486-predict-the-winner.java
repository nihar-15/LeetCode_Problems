class Solution {
    public boolean predictTheWinner(int[] piles) {
       int n = piles.length;
       if(n == 1){
        return true;
       }
        int total = 0 ; 
        int dp[][][] = new int[piles.length][piles.length][2];
        for(int d[][] : dp){
            for(int a[] : d){
                Arrays.fill(a , -1);
            }
        }
        for(int num : piles){
            total += num;
        }
        if(total == 0){
            return true;
        }
        int maxi = func(piles , 0 , n -1 , 0 , dp);
        return (maxi >= (total - maxi));
    }
    int func(int piles[] , int left , int right , int turn , int dp[][][]){
       if(left > right){
        return 0;
       }
        int ans = 0 ;
        if(dp[left][right][turn] != -1){
            return dp[left][right][turn];
        }
        if(turn == 0){
            int current = Math.max(piles[left] + func(piles , left+ 1 , right , 1 ,dp) , piles[right] + func(piles , left , right -1  , 1 , dp));
            ans = Math.max(current , ans);
        }else{
            int current = Math.min(func(piles , left+1 , right , 0 , dp) , func(piles , left , right -1 , 0 ,dp));
            ans = Math.max(current , ans);
        }
        return dp[left][right][turn] =  ans ;
    }
}
