class Solution {
    public int maxSubArray(int[] nums) {
        
        int n=nums.length;
        int max_so_far=Integer.MIN_VALUE,max_end=0;
        for(int i=0;i<n;i++){
            max_end=max_end+nums[i];
            if(max_so_far< max_end){
                max_so_far=max_end;
            }
            if(max_end<0){
                max_end=0;
            }
        }
        
        return max_so_far;
    }
}









/*

   int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here
                                            = 0;
 
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
        
*/