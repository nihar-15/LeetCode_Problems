class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if(totalSum %2 != 0){
            return false;
        }
        return isSubsetSum(nums.length, nums , totalSum / 2);
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int dp[][] = new int[sum][N];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        return func(0 ,arr , sum , 0 , dp);
    }
    
    static boolean func(int i , int arr[] , int sum , int currentSum  , int dp[][]){
        
        if( i == arr.length){
            return currentSum == sum;
        }
        if(sum == currentSum){
            return true;
        }
        if(dp[currentSum][i] != -1){
            return dp[currentSum][i] == 0;
        }
        boolean take = false;
        if(arr[i] + currentSum <= sum){
            take = func(i+1 , arr , sum ,arr[i] + currentSum, dp );
        }
        boolean notTake = func(i +1 , arr , sum , currentSum, dp);
        boolean a = notTake || take;
        if(a == true){
             dp[currentSum][i] = 0;
             return true;
        }
         dp[currentSum][i] =  1 ;
           return false;
    }
}