class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer> a=new ArrayList<>();
        fun(nums,0,ans,a);
    return ans;
    }
    public void fun(int[] nums,int idx,List<List<Integer>> ans,List<Integer> subset){
        ans.add(new ArrayList<>(subset));
        
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            fun(nums,i+1,ans,subset);
            subset.remove(subset.size()-1);
        }
    }
}