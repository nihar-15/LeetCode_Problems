class Solution {
    public int minIncrementForUnique(int[] nums) {
        
         Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += (nums[i - 1] + 1) - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
       /* int n = nums.length;
        int expectedSum = (n*(n+1)) / 2;

        int currentSum = 0;
        for(int num : nums){
            currentSum += num;
        }

        return expectedSum - currentSum;
        */
    }
}