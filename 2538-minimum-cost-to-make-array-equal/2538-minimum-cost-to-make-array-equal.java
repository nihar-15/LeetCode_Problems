class Solution {
    public long minCost(int[] nums, int[] cost) {
       int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        long minimumCost = Long.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            long currentCost1 = func(nums , cost , mid);
            long currentCost2 = func(nums , cost, mid+1);
            minimumCost = Math.min(minimumCost , Math.min(currentCost1 , currentCost2));
            if(currentCost1 > currentCost2){
             left= mid + 1;
           
            }else{
              right = mid - 1;
            }
        }
        return  minimumCost;
    }
    long func(int nums[] , int cost[] , int val){
        int n = nums.length;
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += (long)Math.abs(nums[i] - val) * cost[i];
        }
        return totalCost;
    }
}