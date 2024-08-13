class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        func(candidates, target , 0 , list , new ArrayList<>());
        return list ;
    }
    void func(int arr[] , int target, int idx ,List<List<Integer>> list, List<Integer> subset){
        if(target == 0){
            list.add(new ArrayList<>(subset));
            return ;
        }
        if(idx >= arr.length){
            return ;
        }
        for(int i = idx ; i< arr.length ; i++){
         if(i > idx && arr[i] == arr[i -1 ]){
           continue ;
        }
        if(target < arr[i]){
            break;
        }
        subset.add(arr[i]);
        func(arr , target - arr[i] , i +1 , list , subset);
        subset.remove(subset.size() -1);
        }
       
    }
}