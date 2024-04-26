class Solution {
    public int minFallingPathSum(int[][] matrix) {
     return func2(matrix);
    /*   int n = matrix.length;
       int m = matrix[0].length;

         int dp[][]= new   int[n+1][m+1];
       for(int[] a : dp){
        Arrays.fill(a ,-1);
       }
       int mini =(int) 1e9;
       for(int i=0;i<m;i++){
          int ans = func(matrix, 0 , i, dp);
           mini = Math.min(mini , ans);
     }

        return mini;
        */
  
    }
    /*
    This is written my me And gives TLE
    int func(int [][]matrix, int i ,int j , int dp[][]){
        if(j>= matrix[0].length || j<0){
            return (int)1e9;
        }
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = matrix[i][j]+func(matrix , i+1,j, dp);
        int left = matrix[i][j]+func(matrix , i+1, j-1,dp);
        int right = matrix[i][j]+func(matrix , i+1, j+1,dp);

        return dp[i][j]=Math.min(down , Math.min(left , right));
    }


*/


int func2(int matrix[][]){
     int n = matrix.length;
        int m = matrix[0].length;

        // Initialize dp array
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, dp[i], 0, m);
        }

        // Bottom-up dynamic programming
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int minVal = dp[i + 1][j];
                if (j > 0) {
                    minVal = Math.min(minVal, dp[i + 1][j - 1]);
                }
                if (j < m - 1) {
                    minVal = Math.min(minVal, dp[i + 1][j + 1]);
                }
                dp[i][j] += minVal;
            }
        }

        // Find the minimum path sum in the first row
        int minPathSum = Integer.MAX_VALUE;
        for (int val : dp[0]) {
            minPathSum = Math.min(minPathSum, val);
        }

        return minPathSum;
}
}