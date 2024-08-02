class Solution {
    public int minSwaps(int[] nums) {
        int arr[] = new int[2 * nums.length];
      int k =0 ; 
      for(int j =0 ; j < 2; j++){
      for(int i =0 ; i<nums.length ; i++){
        arr[k++] = nums[i];
      }
      }
      int oneCount = 0;
      for(int num : nums){
        if(num == 1){
            oneCount ++;
        }
      } 
      if(oneCount == 0){
        return 0 ;
      }
      int left = 0 , right =0;
      int maxi = Integer.MAX_VALUE;
      int currentOne = 0 ;
      for(right =0 ; right< arr.length ; right++){
        if(arr[right] == 1){
            currentOne++;
        }
        if(right - left +1 == oneCount){
          maxi = Math.min(oneCount - currentOne , maxi);
          if(arr[left] == 1){
            currentOne --;
          }
          left++;
        }
      }

      return maxi;
    }
}