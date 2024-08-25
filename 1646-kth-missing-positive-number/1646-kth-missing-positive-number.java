class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length , low = 0 , high = n -1;
        while(low <= high){
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid+1);
            if(missing >= k){
               high = mid -1;
            }else{
               low = mid + 1;
            }
        }
        return  k + low;
    }
}