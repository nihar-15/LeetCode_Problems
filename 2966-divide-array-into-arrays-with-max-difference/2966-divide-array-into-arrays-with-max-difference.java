class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
      Arrays.sort(nums);

        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        int i = 0;

        while (i < n) {
            if (i + 2 < n && nums[i + 2] - nums[i] <= k) {
                ans[i / 3][0] = nums[i++];
                ans[i / 3][1] = nums[i++];
                ans[i / 3][2] = nums[i++];
            } else {
                // If it's not possible to create a valid array, return an empty array
                return new int[0][0];
            }
        }

        return ans;
        
        
        
    }
}