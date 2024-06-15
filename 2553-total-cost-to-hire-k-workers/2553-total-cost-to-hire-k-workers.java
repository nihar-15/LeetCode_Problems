class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int hired =0 ;
        long cost=0;
        PriorityQueue<Integer> leftPQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> rightPQ = new PriorityQueue<Integer>();
       int i =0  , j = costs.length-1;
       while(hired < k){
        while( leftPQ.size() < candidates  && i <= j ){
            leftPQ.offer(costs[i]);
            i++;
        }
         while(rightPQ.size() < candidates &&  j >= i){
           rightPQ.offer(costs[j]);
            j --;
        }
        int leftMin = Integer.MAX_VALUE;
        int rightMin= Integer.MAX_VALUE;
        if(!leftPQ.isEmpty()){
         leftMin = leftPQ.peek();
        }
         if(!rightPQ.isEmpty()){
            rightMin = rightPQ.peek();
        }
        if(leftMin <= rightMin){
         cost += (long) leftMin;
         leftPQ.poll();

        }else{
         cost += (long) rightMin;
         rightPQ.poll();
        }
        hired++;

       }

       return cost;
    }
}