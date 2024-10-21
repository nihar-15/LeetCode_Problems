class Solution {
    public int longestOnes(int[] nums, int k) {
        // This ques can be alternatively asked as a longest subarray with at most k zeroes
        int left = 0 , right = 0;
        int n = nums.length;
        int ans = 0 ;
        int noOfZeroes = 0;
        while (right < n) {
            if (nums[right] == 0) {
                noOfZeroes++;
            }

            while (noOfZeroes > k) {
                if (nums[left] == 0) {
                    noOfZeroes--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans ;
    }
}