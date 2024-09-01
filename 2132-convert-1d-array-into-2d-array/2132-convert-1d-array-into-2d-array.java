class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
       
        if (original.length != m * n) {
            return new int[0][];
        }

        int[][] result = new int[m][n]; // create a new the 2D array.
        
        
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result; //return the constructed 2D array.
    }
}