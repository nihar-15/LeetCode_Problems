class Solution {
   public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
	int size = nums.size()-(2*k);
	for(int i=0; i<=size; i++) {
		int j=i+1, end = i+k;
		while(j<end && nums.get(j-1) < nums.get(j)) j++;
		if(j<end) continue;

		j++;
		end += k;
		while(j<end && nums.get(j-1) < nums.get(j)) j++;
		if(j==end) return true;;
	}

	return false;
}
}