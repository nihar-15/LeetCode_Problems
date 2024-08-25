class Solution {
    public boolean canJump(int[] nums) {


     int dp[] = new int[nums.length+1];
     Arrays.fill(dp ,-1);
      return func(nums,0 ,dp);

    }

    boolean func(int nums[] , int idx , int dp[]){

     if (idx >= nums.length - 1) {
        return true;
    }

    if (dp[idx] != -1) {
        return dp[idx] == 1; // If dp[idx] is not -1, return true if dp[idx] is 1, otherwise false
    }

    int maxReach = Math.min(idx + nums[idx], nums.length - 1);

    // Traverse through all possible steps from current position
    for (int i = idx + 1; i <= maxReach; i++) {
        if (func(nums, i, dp)) {
            dp[idx] = 1; // Assign 1 to indicate true
            return true;
        }
    }

    dp[idx] = 0; // Assign 0 to indicate false
    return false;
    }
}