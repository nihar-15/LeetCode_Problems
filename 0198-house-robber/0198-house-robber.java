class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp , -1);
        return func(nums, 0 , dp);
    }
    int func(int nums[] , int idx , int dp[]){
        if(idx >= nums.length){
            return 0;
        }
        if(idx == nums.length -1){
            return nums[idx];
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int take = nums[idx] + func(nums, idx+2 , dp);
        int notTake = Integer.MIN_VALUE;
        if(idx + 1 < nums.length){
             notTake = func(nums , idx + 1 , dp);
        }
        return dp[idx] = Math.max(take , notTake);
    }
}