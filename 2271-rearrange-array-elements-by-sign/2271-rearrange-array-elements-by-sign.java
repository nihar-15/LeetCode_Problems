class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        
        if(nums[0]<0 && nums.length==2){
            nums[0]=nums[0]+nums[1];
            nums[1]=nums[0]-nums[1];
            nums[0]=nums[0]-nums[1];
            return nums;
        }
        int[] neg=new int[nums.length];
        int[] pos=new int[nums.length];
        int ind1=0;
        int ind2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                neg[ind1]=nums[i];
                ind1++;
            }
            else{
                pos[ind2]=nums[i];
                ind2++;
            }
        }
        ind1=0;
        ind2=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=pos[ind1];
                ind1++;
            }
            else{
                nums[i]=neg[ind2];
                ind2++;
            }
        }
        
        return nums;
    }
    
}