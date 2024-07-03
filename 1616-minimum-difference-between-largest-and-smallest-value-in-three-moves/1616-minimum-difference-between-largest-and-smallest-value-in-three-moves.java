class Solution {
    public int minDifference(int[] nums) {
        
        if(nums.length<=4){
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int left =0 ;left <=3;left++ ){
            minDiff = Math.min(minDiff , nums[nums.length- 4 + left] - nums[left] );
        }
     return minDiff;
    }
}



















