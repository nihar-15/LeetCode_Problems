class Solution {
    public int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        for (int c : candies) {
            totalCandies += c;
        }
        
        if (totalCandies < k) {
            return 0;
        }
        
        int low = 1;
        int high = (int)(totalCandies / k);  
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canDistribute(candies, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high;
    }

    boolean canDistribute(int[] candies, int number, long k) {
        long numberOfChildren = 0;
        
        for (int i = 0; i < candies.length; i++) {
            numberOfChildren += candies[i] / number;
            if (numberOfChildren >= k) {
                return true;
            }
        }
        
        return numberOfChildren >= k;
    }
}
