class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int[][] dp = new int[nums.length + 1][target + 100001]; // Adjusted dimensions
        
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize each row
        }
        
        return func(target, nums, nums.length - 1, 0, dp);
    }
    
    int func(int target, int nums[], int idx, int currentSum, int dp[][]) {
        if (idx < 0) {
            return currentSum == target ? 1 : 0;
        }
        
        if (dp[idx][currentSum + 50000] != -1) { 
            return dp[idx][currentSum + 50000];
        }
        
        int countWithCurr = func(target, nums, idx - 1, currentSum + nums[idx], dp);
        int countWithoutCurr = func(target, nums, idx - 1, currentSum - nums[idx], dp);
        
        return dp[idx][currentSum + 50000] = countWithCurr + countWithoutCurr; // Adjusted indexing
    }
}