class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low =1 , high =findMax(nums);
        
        while( low <= high){
            int mid = (low+ high)/2;
            int sum = sumByD(nums , mid);
            if(sum <= threshold){
                high = mid -1;
            }else{
                low = mid+1;
            }
            
        }
        
        return low;
        
    }
    
    static int sumByD(int arr[] , int div){
        int n = arr.length;
        int sum =0;
        for(int i =0; i<n; i++){
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }
    
 static int findMax(int arr[]){
           int n = arr.length;
           int max= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           max= Math.max(max, arr[i]);  
            //System.out.println(max);
        }
           return max;
    }
                                
                                
}