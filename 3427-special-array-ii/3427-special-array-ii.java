class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        
        // Edge case: If nums length is 1, every subarray is special
        if (n == 1) {
            boolean[] result = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                result[i] = true;
            }
            return result;
        }
        
        int[] sameParityPrefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            sameParityPrefixSum[i] = sameParityPrefixSum[i - 1] + ((nums[i] % 2) == (nums[i - 1] % 2) ? 1 : 0);
        }
        
        boolean[] result = new boolean[queries.length];
        
        for (int q = 0; q < queries.length; q++) {
            int from = queries[q][0];
            int to = queries[q][1];
            
            
            int sameParityCount = sameParityPrefixSum[to] - sameParityPrefixSum[from];
            
            // 
            result[q] = (sameParityCount == 0);
        }
        
        return result;
    }
}
