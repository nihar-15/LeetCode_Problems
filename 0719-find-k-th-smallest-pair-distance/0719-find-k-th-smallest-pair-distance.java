class Solution {
    public int smallestDistancePair(int[] nums, int k) {
    /* PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
     for(int i = 0 ; i < nums.length  ; i++){
        for(int j = i+1 ; j< nums.length; j++){
            int a = Math.abs(nums[i] - nums[j]);
            pq.offer(a);
            if(pq.size() > k){
                pq.poll();
            }
        }
     }   
     return pq.poll();
     */
       int n = nums.length;
        int maxEl = Arrays.stream(nums).max().getAsInt();
        int[] vec = new int[maxEl + 1];

        // All pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(nums[i] - nums[j]);
                vec[d]++;
            }
        }

        for (int d = 0; d <= maxEl; d++) {
            k -= vec[d];
            if (k <= 0) {
                return d; 
            }
        }
        return -1;
    }
}