class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1 ,o2) -> Integer.compare(o2 ,o1));
       int cnt =0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
              pq.offer(matrix[i][j]);
              if(pq.size() > k){
                pq.poll();
              }
            }
        }
        return pq.poll();
    }
}