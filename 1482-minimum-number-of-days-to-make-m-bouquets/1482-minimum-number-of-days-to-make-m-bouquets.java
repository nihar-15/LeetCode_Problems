class Solution {
    public int minDays(int[] arr, int m, int k) {
        
        long val = (long) m*k;
        int n = arr.length;
        if(val > n) return -1;

        int mini = Integer.MAX_VALUE , maxi = Integer.MIN_VALUE;
         for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        
        int low =mini , high = maxi;
        while( low <= high){
            int mid = (low + high)/2;
            if(isPossible(arr, mid , m , k)){
                high = mid -1;
            }else{
                low = mid+1;
            }
            
        }
        return low;
    }
    
    boolean isPossible(int arr[] , int days, int m , int k){
        
        int n = arr.length;
        int cnt =0 , noOfB =0;
        
        for(int i=0;i<n;i++){
            if(arr[i] <= days){
                cnt++;
            }else{
                noOfB += (cnt /k);
                cnt =0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }
}