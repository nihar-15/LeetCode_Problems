class Solution {
    public int maxProduct(int[] nums) {
          PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
             for(int num:nums){
                maxHeap.offer(num);
             }

             return ( (maxHeap.poll()-1)* (maxHeap.poll() -1));
    }
}