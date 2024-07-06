class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
      List<Integer> arr = new ArrayList<>();
      for (int num : nums) {
        arr.add(num);
      }
       int first = arr.get(0);
      arr.remove(0);
       int ans1 = rob2(arr);
       arr.add(0 , first);
       int last = arr.get(nums.length-1);
       arr.remove(nums.length-1);
       int ans2 = rob2(arr);
       return Math.max(ans1 , ans2);
    }
     public int rob2(List<Integer> nums) {
        int dp[] = new int[nums.size()+1];
        Arrays.fill(dp , -1);
        return func(nums, 0 , dp);
    }
    int func(List<Integer> nums, int idx , int dp[]){
        if(idx >= nums.size()){
            return 0;
        }
        if(idx == nums.size() -1){
            return nums.get(idx);
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int take = nums.get(idx)+ func(nums, idx+2 , dp);
        int notTake = Integer.MIN_VALUE;
        if(idx + 1 < nums.size()){
             notTake = func(nums , idx + 1 , dp);
        }
        return dp[idx] = Math.max(take , notTake);
    }
}