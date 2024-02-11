class Solution {
    public int search(int[] nums, int target) {
         int n = nums.length;
    int low = 0, high = n - 1;
    int ans = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        System.out.println(mid + "  " + nums[mid]);
        if (nums[mid] == target) {
            ans = mid;
            break; // Once target is found, we can exit the loop
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
    return ans;
        
    }
}