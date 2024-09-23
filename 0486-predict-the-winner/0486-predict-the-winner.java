class Solution {
    int dp[][] = new int[23][23];
    public boolean predictTheWinner(int[] nums) {
        int sum =0 ;
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        int n  = nums.length ;
        for(int num : nums){
            sum += num ;
        }
        int player1 = func(nums , 0 , n-1);
        int player2 = sum - player1;
        return player1 >= player2;
    }
    int func(int nums[] , int i , int j ){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == j){
            return nums[i];
        }
        int takeIth = nums[i] + Math.min(func(nums , i+2 ,j) , func(nums , i +1 , j-1));
        int takeJth = nums[j] + Math.min(func(nums , i , j -2) , func(nums , i+1  , j -1));
        return dp[i][j] = Math.max( takeIth , takeJth);
    }
}