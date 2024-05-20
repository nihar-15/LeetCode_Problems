class Solution {
    public int lengthOfLIS(int[] nums) {
/*
       // Aniruddha Agrawal sir
       int[] dp = new int[nums.length];
    int max = 0;
    for(int num : nums) {
        int index = Arrays.binarySearch(dp, 0, max, num);
        if(index < 0) index = Math.abs(index) - 1;
        dp[index] = num;
        if(index == max) ++max;
    }
    
    return max;
 */
       int dp[][] = new int[nums.length][nums.length+1];
       for(int []d: dp){
             Arrays.fill(d , -1);
       }
        return func(nums ,0 , -1 ,dp);
       
    }

    int func(int nums[] , int idx , int prevIdx , int dp[][] ){
        
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1] ;
        }
        int a =0, b=0;
       if(prevIdx == -1 || nums[idx] > nums[prevIdx] ){
        a = 1+ func(nums, idx+1, idx ,dp);
       }
        b = 0 + func(nums , idx+1 , prevIdx , dp);
    return dp[idx][prevIdx+1] = Math.max(a ,b);
    }
}