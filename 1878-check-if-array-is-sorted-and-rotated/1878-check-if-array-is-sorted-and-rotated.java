class Solution {
    public boolean check(int[] nums) {
       int drops = 0 ;
       for(int i = 1; i < nums.length ; i++){
        if(nums[i-1] > nums[i]){
            drops++;
        }
       }
        if(nums[0] < nums[nums.length - 1]) drops++;
        
       
        return drops <= 1;
       /* if(nums.length == 1){
            return true;
        }
        List<Integer> numbers = new ArrayList<>();
        int maxSorted = 1 ;
        for(int i = 0 ; i < 2 ; i++){
        for(int num : nums){
            numbers.add(num);
        }
        }
        int curr = 1;
        int prev = numbers.get(0);
       for(int i = 1; i < numbers.size() ; i++){
        int currNumber = numbers.get(i); 
        if(currNumber >= prev ){
            curr ++;
            prev = currNumber;
        }else{
            
            prev =  currNumber;
            curr = 1;
        }
        maxSorted = Math.max(maxSorted , curr);
        if(maxSorted == nums.length){
            return true;
        }
       }
       System.out.println(maxSorted);
       return false ;
       */
    }
}