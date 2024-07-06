class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int [] temparr=new int [nums.length-1];
        int [] temparr2=new int [nums.length-1];
        for(int i=0;i<temparr.length;i++){
            temparr[i]=nums[i];
            temparr2[i]=nums[i+1];
        }
        return Math.max(rob1(temparr),rob1(temparr2));
    }
    public int rob1(int[] nums) {
        int [] dp=new int [nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return solve(nums.length-1,nums,dp);
    }
    public int solve(int n,int[] nums,int[] dp){
        if(n<0){
            return 0;
        }

        int take=(dp[n]!=-1)? dp[n]:nums[n]+solve(n-2,nums,dp);
        int not=-1;
        if(n>0)not=(dp[n-1]!=-1)? dp[n-1]:solve(n-1,nums,dp);
        dp[n]=Math.max(take,not);
        return Math.max(take,not);
    }
}