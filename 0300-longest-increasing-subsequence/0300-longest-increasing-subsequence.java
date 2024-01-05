class Solution {
    public int lengthOfLIS(int[] nums) {
     
        int n=nums.length;
       int dp[][]=new int[n][n+1]; 
        
         for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

       int ans= func(0,-1,nums,dp);
        
        return ans;
    }
    
    private static int func(int curr,int prev,int[] nums,int dp[][]){
        
        if(curr==nums.length){
            return 0;
        }
        
        if(dp[curr][prev+1]!=-1){
            return dp[curr][prev+1];
        }

        
        int len =0+func(curr+1,prev,nums,dp);
        
        if(prev==-1 || nums[curr]> nums[prev]){
            len=Math.max(len,1+func(curr+1,curr,nums,dp));
        }
        
        return dp[curr][prev+1]=len;
    }
}