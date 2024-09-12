class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long consecutiveZeros = 0;

        for (int num : nums) {
            if (num == 0) {
                consecutiveZeros++;
                count += consecutiveZeros;
            } else {
                consecutiveZeros = 0;
            }
        }

        return count;
    }
}
