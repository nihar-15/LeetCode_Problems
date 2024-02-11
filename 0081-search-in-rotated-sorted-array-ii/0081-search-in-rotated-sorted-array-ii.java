class Solution {
    public boolean search(int[] nums, int target) {
        
        
        
         int n = nums.length;
    int low = 0, high = n - 1;
    int ans = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        System.out.println(mid + "  " + nums[mid]);
        if (nums[mid] == target) {
             return true;    //// Once target is found, we can exit the loop
        }
        
         if (nums[low] == nums[mid] && nums[mid] ==  nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

        if (nums[mid] >= nums[low]) {
            if (nums[low] <= target && target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            if (nums[mid] <= target && target <= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return false;
        
    }
}