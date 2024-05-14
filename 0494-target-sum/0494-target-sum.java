class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         return func(target, nums, nums.length - 1, 0);
    }
    
    int func(int target, int nums[], int idx, int currentSum) {
        if (idx < 0) {
            return currentSum == target ? 1 : 0;
        }
        
        int countWithCurr = func(target, nums, idx - 1, currentSum + nums[idx]);
        int countWithoutCurr = func(target, nums, idx - 1, currentSum - nums[idx]);
        
        return countWithCurr + countWithoutCurr;
    }
}