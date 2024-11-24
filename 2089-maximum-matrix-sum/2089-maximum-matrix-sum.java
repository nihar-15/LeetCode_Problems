class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long mini = Long.MAX_VALUE;
        int negative = 0 ;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                if(matrix[i][j] < 0){
                    negative++;
                }
                mini = Math.min(Math.abs(matrix[i][j]), mini);
                sum += Math.abs(matrix[i][j]);
            }
           
        }
         if(negative %2 != 0){
                return (sum -= 2*mini);
            }
            return sum;
    }
}