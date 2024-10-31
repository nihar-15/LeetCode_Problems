class Solution {
    public int shipWithinDays(int[] weights, int days) {
          
       int maxi = Integer.MIN_VALUE;
       int sum =0;
       for(int i=0;i<weights.length;i++){
         sum += weights[i];
         maxi = Math.max(maxi , weights[i]);
       }
            

         return fun(weights, maxi , sum , days);
    }

    int fun(int arr[] , int low , int high , int M){
          
          int N = arr.length;
        if(M>N){
            return -1;
        }
        while( low<= high){
            int mid = low+ (high - low)/2;
            if(canAllocate(arr, mid) > M){
                 low= mid+1;
              
            }else{
               high = mid -1;
            }
            
        }
        
        return low;
        
    }
    
    
    
    public  static int canAllocate(int arr[] , int pages ){
        
        int k = 1;
        int sum =0;
        for(int i =0;i<arr.length;i++){
            if(sum+arr[i] <= pages){
                sum += arr[i];
            }else{
                k++;
                sum= arr[i];
            }
        }
        
        return k;

    }
}