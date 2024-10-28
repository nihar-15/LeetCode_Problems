class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxStreak = 0;
        Arrays.sort(nums);
        for(int num : nums){
            int root = (int)Math.sqrt(num);
            if (root * root == num && map.containsKey(root)) {
                map.put(num, map.get(root) + 1);
            } else {
                map.put(num, 1);
            }
            maxStreak = Math.max(maxStreak, map.get(num));
        }
        if(maxStreak < 2){
            return -1 ;
        }
        return maxStreak ;
    }
}


