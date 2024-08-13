class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        func(candidates , target , 0 ,  ans , new ArrayList<>());
        return ans; 
    }
    void func(int arr[] , int target , int idx , List<List<Integer>> ans , List<Integer> subset){
        if(target == 0){
            ans.add(new ArrayList<>(subset));
            return ;
        }
        for(int i = idx ; i < arr.length ; i++){
            if(arr[idx] > target){
                break;
            }
            subset.add(arr[i]);
            func(arr , target - arr[i] , i , ans , subset);
            subset.remove(subset.size() - 1);
        }
    }
}