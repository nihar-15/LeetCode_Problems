class Solution {
    public int lengthOfLIS(int[] nums) {

       // Aniruddha Agrawal sir
       int[] dp = new int[nums.length];
    int max = 0;
    for(int num : nums) {
        int index = Arrays.binarySearch(dp, 0, max, num);
        if(index < 0) index = Math.abs(index) - 1;
        dp[index] = num;
        if(index == max) ++max;
    }
    
    return max;
 
       
    }
}