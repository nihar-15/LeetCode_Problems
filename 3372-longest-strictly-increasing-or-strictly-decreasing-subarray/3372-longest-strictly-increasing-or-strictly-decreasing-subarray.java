class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
    
        if (nums.length == 0)
            return 0;
        
        int maxLength = 1;
        int currentLength = 1;
        
        // Direction of the current monotonic subarray (0 for unknown, 1 for increasing, -1 for decreasing)
        int direction = 0;
        
        for (int i = 1; i < nums.length; i++) {
            // Comparing current element with previous one to determine direction
            int newDirection = Integer.compare(nums[i], nums[i - 1]);
            
            if (newDirection != 0) {
                if (direction == 0) {
                    // If direction was unknown, set it to the new direction
                    direction = newDirection;
                    currentLength++;
                } else if (direction == newDirection) {
                    // If direction remains the same, increment the current length
                    currentLength++;
                } else {
                    // If direction changes, update maxLength if necessary and reset current length
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 2; // Two elements form the new monotonic subarray
                    direction = newDirection;
                }
            } else {
                // If current element is equal to previous one, reset current length
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
                direction = 0; // Reset direction
            }
        }
        
        // Update maxLength considering the last monotonic subarray
        maxLength = Math.max(maxLength, currentLength);
        
        return maxLength;


    }
}