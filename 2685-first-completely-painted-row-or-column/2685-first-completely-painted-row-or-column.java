class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
          int rows = mat.length; 
          int cols = mat[0].length; 
          int[] rowCount = new int[rows];
          int[] colCount = new int[cols];
         Map<Integer, int[]> positionMap = new HashMap<>();
          Arrays.fill(rowCount , cols);
          Arrays.fill(colCount , rows);
          for(int r =0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                positionMap.put(mat[r][c] , new int[]{r , c});
            }
          }
          for(int i = 0; i < arr.length ; i++){
            int pos[] = positionMap.get(arr[i]);
            if(--rowCount[pos[0]] == 0 || --colCount[pos[1]] == 0 ){
                return i;
            }
          }
          return -1;
    }
}