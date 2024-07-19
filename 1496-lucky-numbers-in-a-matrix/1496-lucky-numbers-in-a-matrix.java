class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int row[] = new int[m];
        int col[] =new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<m ; i++){
            int currentMini = Integer.MAX_VALUE;
            for(int j = 0 ; j < n ; j++){
               currentMini = Math.min(matrix[i][j] , currentMini);
               row[i] = currentMini;
            }
        }
         for(int i =0;i< n ; i++){
            int currentMaxi = Integer.MIN_VALUE;
            for(int j = 0 ; j < m ; j++){
               currentMaxi = Math.max(matrix[j][i] , currentMaxi);
               col[i] = currentMaxi;
            }
        }
       for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == matrix[i][j] && col[j] == matrix[i][j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }

return ans;
    }
}