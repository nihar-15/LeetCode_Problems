class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds =  new ArrayList<>();
        boolean isVis[] = new boolean[nums.length];
        findPermutations(nums , ans , ds , isVis );
        return ans;
    }
    void findPermutations(int nums[] , List<List<Integer>> res , List<Integer> ds , boolean[] isVis){
          if(ds.size() == nums.length){
            if(!res.contains(ds)){
            res.add(new ArrayList<>(ds));
            }
            return;
          }
          for(int i =0;i<nums.length;i++){
            if(!isVis[i]){
                isVis[i]= true;
                ds.add(nums[i]);
                findPermutations(nums, res, ds, isVis);
                ds.remove(ds.size()-1);
                isVis[i]= false;
            }
          }
    }
}