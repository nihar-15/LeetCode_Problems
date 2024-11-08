class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
         int n = nums.length;
        int mask = (1 << maximumBit)-1;

        int[] result = new int[n];
        int xor = 0;
        for(int i = 0; i < n; i++){
            xor ^= nums[i];
            int k = xor ^ mask;
            result[n-i-1] = k;
        }

        return result;
    }
}