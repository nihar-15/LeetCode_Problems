class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long ans = 0 ;
        int n = nums1.length;
        long positiveDiff = 0 , totalDiff = 0 ;
       
        
        if(k == 0){
         for(int i =0 ; i< n ; i++){
           if(nums1[i] != nums2[i]){
            return -1;
           }
         }
         return 0;
        }
        
        for(int i = 0 ;i < n ; i++){
          if(Math.abs(nums2[i] - nums1[i]) % k != 0 ){
            return -1;
          }
          
          int diff = nums1[i] - nums2[i];
          if(diff > 0){
            positiveDiff += diff ;
          }
          totalDiff += diff;
        }
        if(totalDiff != 0 || k == 0){
            return -1;
        }
        return positiveDiff / k ;
    }
}