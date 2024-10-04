class Solution {
    public int minMoves(int[] nums) {
     int ans = 0; 
     Arrays.sort(nums);
     int mini = nums[0];
     for(int i =1 ; i < nums.length ; i++){
        ans += (nums[i] - mini);
     }
     return ans;
    }
}