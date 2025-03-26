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

        /*
       int m = matrix.length; int  n = matrix[0].length; 
       int left = matrix[0][0], right = matrix[m-1][n-1], ans = -1;
       while(left <= right){
        int mid = (left+right)>>1;
        if( countLessOrEqualK(matrix , mid) >= k){
            ans =mid;
            right= mid-1;
        }else{
            left = mid+1;
        }
       }
    return ans;
    }

    int countLessOrEqualK(int matrix[][] , int x){
       int m =matrix.length;
       int n = matrix[0].length;
       int c = n-1;
       int count =0;
       for(int i = 0;i<m;i++){
        while(c>=0 && matrix[i][c] > x){
            c--;
        }
        count += (c+1);
       }
       return count;
       */
    }
}