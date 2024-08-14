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
      /* int n = nums.length;
        int maxEl = Arrays.stream(nums).max().getAsInt();
        int[] vec = new int[maxEl + 1];

        
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
        */
        Arrays.sort(nums);
        int n = nums.length ;
        int result = 0;
        int low = 0 , high = nums[n-1] - nums[0];
        while(low <= high){
         int mid = (low + high ) / 2;
         if(countOfPairs(nums , mid) < k){
            
            low = mid+1;
         }else{
            result = mid ;
            high = mid - 1;
         }
        }
      return result ;
    }
    int countOfPairs(int nums[] , int dis){
        int i =0 , j = 0;
        int n = nums.length;
        int pairs = 0;
        while( j < n ){
            while(nums[j] - nums[i] > dis){
                i++;
            }
            pairs += j -i;
            j++;
        }
        return pairs;
    }
}