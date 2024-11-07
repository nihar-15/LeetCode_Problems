class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0 ; 
        for(int pos = 0; pos < 32; pos++){
            int count = 0 ; 
           for (int i = 0; i < candidates.length; i++) {
    if ((candidates[i] & (1 << pos)) != 0) {  // Explicit comparison to 0
        count++;
    }
}
            ans = Math.max(count , ans);
        }
        return ans;
    }
}

