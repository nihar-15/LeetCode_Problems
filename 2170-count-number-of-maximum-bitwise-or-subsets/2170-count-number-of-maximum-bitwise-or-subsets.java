class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maximumOr = 0;
        for(int num : nums){
            maximumOr = maximumOr |  num ;
        }
        List<Integer> arr = new ArrayList<>();
        int count[] = new int[1];
        func(nums , 0 ,  arr , count , maximumOr);
        return count[0];
    }
    void func(int nums[] , int idx , List<Integer> arr  , int count[] , int maximumOr){
        if(idx == nums.length){
            int or = 0 ;
            for(int a : arr){
                or = or | a ;
            }
            if(or == maximumOr){
                count[0] ++;
            }
            return ;
        }
        arr.add(nums[idx]);
        func(nums, idx+1 , arr , count , maximumOr);
        arr.remove(arr.size()-1);
        func(nums , idx +1 , arr , count , maximumOr);
    }
}