class Solution {
    public boolean checkValid(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=0;j<matrix.length;j++){
                if(hs.contains(matrix[i][j])){
                    return false;
                }
                else{
                    hs.add(matrix[i][j]);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=0;j<matrix.length;j++){
                if(hs.contains(matrix[j][i])){
                    return false;
                }
                else{
                    hs.add(matrix[j][i]);
                }
            }
        }
        return true;
    }
}