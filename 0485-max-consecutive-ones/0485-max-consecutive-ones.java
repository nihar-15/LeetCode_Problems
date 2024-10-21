class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0; 
        int currMax = 0 ; 
        for(int num : nums){
        if(num == 0){
            currMax= 0 ;
        }else{
            currMax++;
            ans = Math.max(ans , currMax);
        }
        }
        return ans ;
    }
}