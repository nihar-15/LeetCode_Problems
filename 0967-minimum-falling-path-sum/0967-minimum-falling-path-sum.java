class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        // Copy the last row of matrix to dp
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = matrix[m - 1][j];
        }

        // Fill the dp array from the second last row to the top
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = dp[i + 1][j];
                int downLeft = j > 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int downRight = j < n - 1 ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
            }
        }

        // Find the minimum value in the first row of dp
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }
}
