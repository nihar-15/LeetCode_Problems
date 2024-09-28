class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0 , cnt = 0;
        int n = nums.length;
        map.put(0 , 1);
        for(int i = 0 ; i < n ; i++){
            prefixSum += nums[i]; 
            int remove = prefixSum - goal ;
            cnt += map.getOrDefault(remove , 0);
            map.put(prefixSum , map.getOrDefault(prefixSum ,0) + 1); 
        }
        return cnt;
    }
}