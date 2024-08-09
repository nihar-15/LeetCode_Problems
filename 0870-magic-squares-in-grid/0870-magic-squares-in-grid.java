class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (helper(i, j, grid)) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public boolean helper(int i, int j, int[][] grid) {
        int[] count = new int[10];
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                int num = grid[r][c];
                if (num < 1 || num > 9) return false;
                count[num]++;
            }
        }

        for (int k = 1; k <= 9; k++) {
            if (count[k] != 1) return false;
        }

        int target = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        for (int r = i; r < i + 3; r++) {
            int sum = 0;
            for (int c = j; c < j + 3; c++) {
                
                sum += grid[r][c];
            }
            if (sum != target) return false;
        }

        // Check columns
        for (int c = j; c < j + 3; c++) {
            int sum = 0;
            for (int r = i; r < i + 3; r++) {
                sum += grid[r][c];
            }
            if (sum != target) return false;
        }

        // Check diagonals
        if (grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] != target) return false;
        if (grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] != target) return false;

        return true;
    }
}
