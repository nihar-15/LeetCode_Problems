class Solution {
    public int longestSubarray(int[] nums) {
       int maxi = Arrays.stream(nums).max().getAsInt();
        int ans = 1;
        int len =0;
        for(int i =0 ; i < nums.length; i++){
            if(nums[i] == maxi){  
                    len++;
                    ans= Math.max(ans , len);
                  }else{
                    len = 0;
                  }
               
            }
          
        return ans;
    }
}