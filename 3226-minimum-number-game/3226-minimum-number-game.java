class Solution {
    public int[] numberGame(int[] nums) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
        minHeap.add(num);
    }
       int ans[] = new int[nums.length];
       int k =0;
       for(int a =0;a < nums.length && !minHeap.isEmpty();a++){
        int alice = minHeap.poll();
        int bob = minHeap.poll();
       ans[k++]= bob;
       ans[k++] = alice;
       }

       return ans;
    }
}