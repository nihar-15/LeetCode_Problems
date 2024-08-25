class Solution {
    public int jump(int[] arr) {
        int n = arr.length+1;
        int dp[]  = new int[n];
        Arrays.fill(dp , -1);
        return func(arr , 0  , dp);
    }
     static int func(int arr[] , int idx , int dp[]){
        
        if(idx == arr.length -1){
            return 0;
        }
        int minSteps = Integer.MAX_VALUE -1;
       if(dp[idx] != -1){
        return dp[idx];
       }
        for(int i = 1 ; i<= arr[idx] ; i++){
            if(idx + i < arr.length){
                minSteps = Math.min(minSteps , func(arr, idx + i, dp) +1);
            }
        }
        return dp[idx] = minSteps;
    }
}