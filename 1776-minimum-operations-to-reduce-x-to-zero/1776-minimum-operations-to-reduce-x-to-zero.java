class Solution {
    public int minOperations(int[] nums, int x) {
	int sum = 0;
	for (int num: nums) sum += num;

	int maxLength = -1, currSum = 0;
	for (int l=0, r=0; r<nums.length; r++) {
		currSum += nums[r];
		while (l <= r && currSum > sum - x) currSum -= nums[l++];
		if (currSum == sum - x) maxLength = Math.max(maxLength, r-l+1);
	}

	if(maxLength == -1) return -1;
    else return nums.length - maxLength;
  }
}