class Solution {
    public int minOperations(int[] nums) {
          int n = nums.length;
          int k =3 ;
        boolean isFlipped[] = new boolean[n];
        int flips =0 ;
        int flipCount =0;
        for(int i =0; i < n ; i++){
            if(i >= k && isFlipped[i-k] == true){
                flipCount --;
            }
            if(flipCount %2 == nums[i]){
                if( i + k > n){
                    return -1;
                }
                flipCount++;
                isFlipped[i] = true;
                flips++; 
            }
        }
        return flips;
    }
}