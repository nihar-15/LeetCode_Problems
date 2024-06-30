class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int alter =1 , even =0 , odd =0;
        if(nums[0]%2 == 0){
            even++;
        }else{
            odd++;
        }
        boolean lastOdd = (nums[0]%2 !=0);
        for(int i  = 1;i<n ; i++){
            boolean flag = nums[i]%2==0;
            if(flag){
                if(lastOdd){
                    alter++;
                    lastOdd = false;
                }
                even++;
            }else{
                if(!lastOdd){
                    alter++;
                    lastOdd = true;
                }
                odd++;
            }
        }
        return Math.max(alter, Math.max(odd, even));
    }
}